# Cache Eviction System

A Java implementation of a generic cache system with LRU (Least Recently Used) eviction policy.

## Overview

This project implements a cache system with the following key features:

- Generic implementation supporting any key-value pair types
- LRU (Least Recently Used) eviction policy
- In-memory storage using HashMap
- Thread-safe operations
- Configurable cache capacity

## Components

The system is divided into several key components:

### Core Classes

- [`Cache`](src/main/java/Cache.java) - Main cache implementation
- [`LRU`](src/main/java/EvictionPolicy/LRU.java) - LRU eviction policy implementation
- [`MapBased`](src/main/java/StorageModule/MapBased.java) - HashMap-based storage implementation

### Data Structures

- [`DoublyLinkedList`](src/main/java/algo/DoublyLinkedList.java) - Custom implementation for LRU operations
- [`DoublyLinkedListNode`](src/main/java/algo/DoublyLinkedListNode.java) - Node implementation for the linked list

### Interfaces

- [`Policy`](src/main/java/EvictionPolicy/Policy.java) - Interface for eviction policies
- [`Storage`](src/main/java/StorageModule/Storage.java) - Interface for storage implementations

## Usage

Here's a basic example of how to use the cache:

```java
// Create cache with LRU policy and capacity of 3
Cache<Integer, Integer> cache = new Cache<>(new LRU<>(), new MapBased<>(3));

// Add elements
cache.add(3, 10);
cache.add(5, 30);
cache.add(10, 50);

// Fetch element
cache.fetch(5); // Returns 30
```

## Exception Handling

The system includes custom exceptions:

InvalidElementException - For invalid element operations
NotFoundException - When accessing non-existent keys
StorageFullException - When cache capacity is exceeded
Build
This is a Maven project. To build:

## Requirements:

Java 21
Maven

# Open for contributions - 
