package com.company;

public class Node
{
    public char Character;
    public int Frequency;

    public Node LeftNode;
    public Node RightNode;

    public Node(char character, int frequency)
    {
        Character = character;
        Frequency = frequency;
    }

    public Node(int frequency, Node left, Node right)
    {
        Character = 0;
        Frequency = frequency;
        LeftNode = left;
        RightNode = right;
    }

}
