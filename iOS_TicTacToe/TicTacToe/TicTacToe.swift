//
//  TicTacToe.swift
//  TicTacToe
//
//  Created by Vaidhyanathan, Shivansh on 9/15/23.
//

import Foundation

struct TicTacToe
{
    var currentState: String
    {
        "\(board[0])    \(board[1])    \(board[2])\n\n\(board[3])    \(board[4])    \(board[5])\n\n\(board[6])    \(board[7])    \(board[8])"
    }
    var board: [String] = ["_","_","_","_","_","_","_","_","_"]
    
    var playerTurn: String = "X"
    var turnCount: Int = 0
    
    var winners: [[String]]
    {
        [[board[0],board[1],board[2]],[board[3],board[4],board[5]],[board[6],board[7],board[8]],[board[0],board[3],board[6]],[board[1],board[4],board[7]],[board[2],board[5],board[8]],[board[0],board[4],board[8]],[board[2],board[4],board[6]]]
    }
    
    var gameEnd: Bool = false
  
  
    
    
    mutating func switchPlayer()
    {
        if(playerTurn == "X")
        {
            playerTurn = "O"
        }
        else
        {
            playerTurn = "X"
        }
            
    }
    mutating func turn(position: Int)
    {
        if(valid(at: position) && !gameEnd)
        {
            board[position] = playerTurn
            turnCount+=1
            if(turnCount == 9)
            {
                gameEnd = true
                return
            }
            checkWinner()
            switchPlayer()
        }
            
    }
    
    mutating func valid(at position: Int) -> Bool
    {
        return board[position] == "_"
    }
    
    mutating func checkWinner()
    {
        
        for array in winners
        {
            if(playerTurn == array[0] && playerTurn == array[1] && playerTurn == array[2])
            {
                gameEnd = true
                return
            }
                
        }
        
    }
    
    
}
