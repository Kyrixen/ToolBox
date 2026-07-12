package io.kyrixen.tinyblox.world;

import java.util.HashMap;
import java.util.Map;

import io.kyrixen.tinyblox.world.chunk.Chunk;
import io.kyrixen.tinyblox.world.chunk.ChunkPos;
import io.kyrixen.tinyblox.world.chunk.tile.Tile;
import io.kyrixen.tinyblox.world.chunk.tile.TileStack;

public class Terrain<TTile extends Tile> {

    // Dimensions
    private final int worldW, worldH;
    private final int chunkW, chunkH;

    // For storing chunks
    private final HashMap<ChunkPos, Chunk<TTile>> chunks = new HashMap<>();


    // Constructs terrain
    public Terrain(int worldW, int worldH, int chunkW, int chunkH) {

        this.worldW = worldW;
        this.worldH = worldH;

        this.chunkW = chunkW;
        this.chunkH = chunkH;

    }


    // Find chunk
    public Chunk<TTile> getChunk(short cX, short cY) {
        return chunks.get(new ChunkPos(cX, cY));
    }

    // Global TileStack accessor
    public TileStack<TTile> getWorldTileStack(int worldX, int worldY) {

        short chunkX = (short) Math.floorDiv(worldX, chunkW);
        short chunkY = (short) Math.floorDiv(worldY, chunkH);

        Chunk<TTile> chunk = this.getChunk(chunkX, chunkY);

        if(chunk == null) return null;

        byte localX = (byte) Math.floorMod(worldX, chunkW);
        byte localY = (byte) Math.floorMod(worldY, chunkH);

        return chunk.getTileStack(localX, localY);

    }

    // Get world height at cordinates
    public byte getWorldLevel(int worldX, int worldY) {

        TileStack<TTile> stack = getWorldTileStack(worldX, worldY);

        if(stack == null) return 0;

        TTile top = stack.top();

        if(top == null) return 0;

        return top.level();
    
    }

    // Get chunk map
    public Map<ChunkPos, Chunk<TTile>> getChunks() { return this.chunks; }

    public boolean hasChunk(short x, short y) {
        return chunks.containsKey(new ChunkPos(x, y));
    }

    public void addChunk(Chunk<TTile> chunk) {
        chunks.put(new ChunkPos(chunk.getX(), chunk.getY()), chunk);
    }

    public Chunk<TTile> removeChunk(short x, short y) {
        return chunks.remove(new ChunkPos(x, y));
    }

    // Chunk count helpers
    public int getChunkCountX() { return (worldW + chunkW - 1) / chunkW; }
    public int getChunkCountY() { return (worldH + chunkH - 1) / chunkH; }

}
