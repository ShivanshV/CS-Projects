//
//  ViewController.swift
//  Wordle
//
//  Created by Vaidhyanathan, Shivansh on 3/21/24.
//

import UIKit

class GameViewController: UIViewController {

    @IBOutlet var playerGuess: UITextField!
    var game = Wordle()
    @IBOutlet var test: LetterTile!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        playerGuess.text = game.answer
        test.status = .correct
        
    }
}

