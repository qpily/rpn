package com.rpn.model;

public class NumberTreeNode {
  private double value;
  private NumberTreeNode first;
  private NumberTreeNode second;

  public NumberTreeNode(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public NumberTreeNode getFirst() {
    return first;
  }

  public void setFirst(NumberTreeNode first) {
    this.first = first;
  }

  public NumberTreeNode getSecond() {
    return second;
  }

  public void setSecond(NumberTreeNode second) {
    this.second = second;
  }
}
