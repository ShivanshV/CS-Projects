//
//  ViewController.swift
//  TicTacToe
//
//  Created by Vaidhyanathan, Shivansh on 9/15/23.
//

import UIKit

class ViewController: UIViewController {
    var game = TicTacToe()
    @IBOutlet var restart: UIButton!
    @IBOutlet var Board: UILabel!
    override func viewDidLoad() {
        Board.text = game.currentState
        restart.isHidden = true
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func playerTurn(_ sender: UIButton) {
        game.turn(position: sender.tag)
        Board.text = game.currentState
        if(game.gameEnd)
        {
            restart.isHidden = false
        }
    }
    @IBAction func restart(_ sender: Any) {
        game = TicTacToe()
        Board.text = game.currentState
        restart.isHidden = true
    }
}

