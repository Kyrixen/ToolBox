# Kyrixen Libraries

A collection of lightweight, independent Java libraries extracted from my game development projects.

All libraries target **Java 8**, have minimal or no external dependencies, and are designed to be reusable in any Java application.

## Libraries

### HeightStack

A layered terrain library for representing height-based worlds.

**Features**

- Generic terrain model
- Chunk-based storage
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

**Features**

- Axis-Aligned Bounding Boxes (AABB)
- Collision detection
- Distance calculations
- Pure Java

---

### Logger

A lightweight color console logger.

**Features**

- ANSI color support
- Optional debug logging
- Built-in info, warn, error, and debug levels
- Pure Java

---

### Randoms

A lightweight random generator.

**Features**

- Simple
- Support for Int, Byte, Float, Boolean
- Random and Seeded generators
- Pure Java

---

## Installation

### Gradle

```kotlin
implementation("io.github.kyrixen:heightstack:0.1.0")
implementation("io.github.kyrixen:collision:0.1.0")
implementation("io.github.kyrixen:logger:0.1.0")
implementation("io.github.kyrixen:randoms:0.1.0")
```

### Maven

```xml
<dependency>
    <groupId>io.github.kyrixen</groupId>
    <artifactId>heightstack</artifactId>
    <version>0.1.0</version>
</dependency>

<dependency>
    <groupId>io.github.kyrixen</groupId>
    <artifactId>collision</artifactId>
    <version>0.1.0</version>
</dependency>

<dependency>
    <groupId>io.github.kyrixen</groupId>
    <artifactId>logger</artifactId>
    <version>0.1.0</version>
</dependency>

<dependency>
    <groupId>io.github.kyrixen</groupId>
    <artifactId>randoms</artifactId>
    <version>0.1.0</version>
</dependency>
```

## License

Licensed under the Apache License 2.0.
