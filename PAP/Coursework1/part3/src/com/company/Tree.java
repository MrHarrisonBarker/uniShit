package com.company;

import java.util.*;

public class Tree
{

    public Node RootNode = null;

    public Tree()
    {

    }

    public Tree(String text)
    {
        // Build tree using created frequency list
        BuildTree(CreateFrequencyList(text));
    }

    // Method to create a list all characters in a string with their corresponding frequencies
    public List<Node> CreateFrequencyList(String text)
    {
        // Create list to store all nodes
        List<Node> characterFrequencyList = new ArrayList<>();

        // Convert text into array of chars and loop through all
        for (char c : text.toCharArray())
        {
            boolean exists = false;
            // Loop through all nodes in the current list
            for (int i = 0; i < characterFrequencyList.size(); i++)
            {
                Node elm = characterFrequencyList.get(i);
                // If the character already exists in the list increase it's frequency
                if (elm.Character == c)
                {
                    elm.Frequency++;
                    characterFrequencyList.set(i, elm);
                    exists = true;
                    break;
                }
            }

            // If the character is not already in the list add a new node with a frequency of 1
            if (!exists)
            {
                characterFrequencyList.add(new Node(c, 1));
            }

        }

        System.out.println("Created frequency list: " + new Date());

        return characterFrequencyList;

    }

    // Method to build the Huffman tree
    public void BuildTree(List<Node> nodes)
    {
        // Looping though all the nodes until theres only the root node left
        while (nodes.size() > 1)
        {
            // sorting array descending
            nodes.sort((o1, o2) -> o2.Frequency - o1.Frequency);

            // getting and removing the two smallest elements in the list
            Node first = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            Node second = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);

            // Create new node with the frequency of first + second
            // first node is set to the left node
            // second node is set to the right node
            Node node = new Node(first.Frequency + second.Frequency, first, second);
            // set current node to the root node
            RootNode = node;

            // add the sum of the two nodes back into the list
            nodes.add(node);
        }

        PrintHuffmanCode(RootNode, "");
    }

    // Method for printing out all Huffman codes for the tree built
    public static void PrintHuffmanCode(Node node, String text)
    {
        // if there is nothing left then return nothing
        if (node == null)
        {
            return;
        }

        // If the last node in the chain has been found then print
        if (node.LeftNode == null && node.RightNode == null && node.Character != 0)
        {
            System.out.printf("%s : %s", node.Character, text);
            System.out.println();
            return;
        }

        PrintHuffmanCode(node.LeftNode, text + "0"); // if left then add 0
        PrintHuffmanCode(node.RightNode, text + "1"); // if right then add 1
    }
}

