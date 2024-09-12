package com.jssdvv.ara.machines.presentation.ar_camera

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.android.filament.Engine
import com.google.ar.core.AugmentedImage
import com.google.ar.core.AugmentedImageDatabase
import com.google.ar.core.Config
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.AugmentedImageNode
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import io.github.sceneview.node.Node
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes
import io.github.sceneview.rememberView

@SuppressLint("UnrememberedMutableState")
@Composable
fun ArCameraScreen(
    navHostController: NavHostController
) {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)
    val nodes = rememberNodes()

    ARSceneExample(
        engine,
        nodes,
        modelLoader
    )
}

@Composable
fun ARSceneExample(
    engine: Engine,
    nodes: List<Node>,
    modelLoader: ModelLoader
) {
    val node = rememberNodes()

    val context = LocalContext.current
    val inputStream = context.assets.open("images/qr_example.jpg")
    val bitmap = BitmapFactory.decodeStream(inputStream)

    val imageNodes = remember { mutableListOf<AugmentedImageNode>() }

    ARScene(
        engine = engine,
        view = rememberView(engine),
        modelLoader = modelLoader,
        childNodes = node,
        planeRenderer = false,
        sessionConfiguration = { session, config ->
            val imageDatabase = AugmentedImageDatabase(session)
            imageDatabase.addImage("QR", bitmap, 0.06f) // Ensure 0.06f matches real-world size

            config.setAugmentedImageDatabase(imageDatabase)
            config.instantPlacementMode = Config.InstantPlacementMode.DISABLED
            config.lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR
            config.depthMode = when (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                true -> Config.DepthMode.AUTOMATIC
                else -> Config.DepthMode.DISABLED
            }
        },
        onSessionUpdated = { session, updatedFrame ->
            val updatedAugmentedImages =
                updatedFrame.getUpdatedTrackables(AugmentedImage::class.java)

            updatedAugmentedImages.forEach { augmentedImage ->
                if (imageNodes.none { it.imageName == augmentedImage.name }) {
                    val imageNode = AugmentedImageNode(engine, augmentedImage)

                    imageNode.apply {
                        when (augmentedImage.name) {
                            "QR" -> {
                                addChildNode(
                                    ModelNode(
                                        modelLoader.createModelInstance("models/CUBO_GLTF.glb"),
                                        centerOrigin = Position(0.0f)
                                    )
                                )
                            }
                            "QR2" -> {}
                        }
                        isVisible = true
                    }

                    node.add(imageNode)
                    imageNodes.add(imageNode)
                }
            }
        }
    )
}
