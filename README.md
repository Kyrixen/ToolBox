# Kyrixen Libraries

A collection of lightweight Java libraries extracted from my game development projects.

All libraries target **Java 8** and have minimal or no external dependencies.

## Libraries

### HeightStack

A layered height-based terrain library.

Features:

- Generic terrain model
- Chunk-based storage
- Vertical TileStacks
- Generic tile types
- Pure Java

```
Terrain
└── Chunk
    └── TileStack
        └── Tile
```

---

### Collision

A lightweight 2D collision library.

Features:

- Axis-Aligned Bounding Boxes (AABB)
- Collision testing
- Distance calculations
- Zero dependencies

---

## Installation

### Gradle

```kotlin
implementation("dev.kyrixen.libs:heightstack:1.0.0")
implementation("dev.kyrixen.libs:collision:1.0.0")
```

### Maven

```xml
<dependency>
    <groupId>dev.kyrixen.libs</groupId>
    <artifactId>heightstack</artifactId>
    <version>1.0.0</version>
</dependency>

<dependency>
    <groupId>dev.kyrixen.libs</groupId>
    <artifactId>collision</artifactId>
    <version>1.0.0</version>
</dependency>
```

## License

Licensed under the Apache License 2.0.