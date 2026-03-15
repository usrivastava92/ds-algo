package com.ib.heaps;

import java.util.*;
import lombok.ToString;

public class LRUCache {}

class Solution {

  Map<Integer, Element> map = new HashMap<>();
  Element start;
  Element end;
  int capacity;

  public Solution(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Element element = removeElementFromMap(key);
      addElementToMap(element);
      return element.value;
    }
    return -1;
  }

  private Element removeElementFromMap(int key) {
    Element element = map.remove(key);
    boolean removed = false;
    if (element == start) {
      removed = true;
      start = start.next;
      if (start != null) {
        start.prev = null;
      }
    }
    if (element == end) {
      removed = true;
      end = end.prev;
      if (end != null) {
        end.next = null;
      }
    }

    if (!removed) {
      Element next = element.next;
      Element prev = element.prev;
      prev.next = next;
      next.prev = prev;
    }
    return element;
  }

  private void addElementToMap(Element element) {
    if (end == null) {
      start = element;
      end = element;
    } else {
      end.next = element;
      element.prev = end;
      end = end.next;
    }
    map.put(element.key, element);
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      Element element = removeElementFromMap(key);
      element.value = value;
      addElementToMap(element);
      return;
    }
    Element elementToBeInserted = new Element();
    elementToBeInserted.key = key;
    elementToBeInserted.value = value;
    if (map.size() == this.capacity) {
      removeElementFromMap(start.key);
    }
    addElementToMap(elementToBeInserted);
  }

  public void printMap() {
    System.out.println(map);
  }
}

@ToString
class Element {

  int key;
  int value;
  @ToString.Exclude Element next;
  @ToString.Exclude Element prev;
}
