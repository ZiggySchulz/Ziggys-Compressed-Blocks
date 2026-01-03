# Ziggy's Compressed Blocks

A light Minecraft mod that adds various compressed blocks for convenience and block variety. 

The goal of this mod isn't to compress every block, or recursive compressions, as these mods exist already (checkout CB: Compressed Blocks for a cool example). The goal if these mod is to target the obvious cases in a polished way (e.g. compressed blaze rod blocks emit light). 

This mod is perfect for running your items from a farm into a crafter before heading to storage.

## Building / Installing

Run
`./gradew runDatagen && ./gradlew build`

The mod will be placed in `build/libs/`
Copy the .jar file to your Minecraft mods folder. Ignore the sources file

## Contributing

Pull requests and suggestions are welcome! New blocks can easily be added by adding it to the ModBlocks.java file and adding a texture to `src/main/resources/assets/textures/`