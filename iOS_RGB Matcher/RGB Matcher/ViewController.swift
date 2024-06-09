//
//  ViewController.swift
//  RGB Matcher
//
//  Created by Vaidhyanathan, Shivansh on 10/3/23.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var GameColorView: UIView!
    @IBOutlet var GuessView: UIView!
    @IBOutlet var RedSlider: UISlider!
    @IBOutlet var GreenSlider: UISlider!
    @IBOutlet var BlueSlider: UISlider!
    @IBOutlet var timeLabel: UILabel!
    
    var timer = Timer()
    
    var red: Float{
        RedSlider.value
    }
    var green: Float{
        GreenSlider.value
    }
    var blue: Float{
        BlueSlider.value
    }
    
    var gameRed: Float = 1
    var gameGreen: Float = 1
    var gameBlue: Float = 1
    
    var totalTime = 13
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        GuessView.layer.borderColor = UIColor.black.cgColor
        GuessView.layer.borderWidth = 4
        GameColorView.layer.borderColor = UIColor.black.cgColor
        GameColorView.layer.borderWidth = 4
        startGame()
        
    }


    @IBAction func SliderChanged(_ sender: UISlider) {
        print("test")
        switch sender.tag {
        case 0:
            GuessView.layer.backgroundColor = UIColor(red: CGFloat(RedSlider.value), green: CGFloat(green), blue: CGFloat(blue), alpha: 1).cgColor
            break
        case 1:
            GuessView.layer.backgroundColor = UIColor(red: CGFloat(red), green: CGFloat(sender.value), blue: CGFloat(blue), alpha: 1).cgColor
            break
        case 2:
            GuessView.layer.backgroundColor = UIColor(red: CGFloat(red), green: CGFloat(green), blue: CGFloat(sender.value), alpha: 1).cgColor
            break
        default:
            GuessView.layer.backgroundColor = UIColor.white.cgColor
        }
    }
    
    
    func startGame()
    {
        totalTime = 13
        timeLabel.text = String(totalTime)
        gameRed = Float.random(in: 0...1)
        gameGreen = Float.random(in: 0...1)
        gameBlue = Float.random(in: 0...1)
        
        RedSlider.setValue(0.5, animated: true)
        BlueSlider.setValue(0.5, animated: true)
        GreenSlider.setValue(0.5, animated: true)

        GameColorView.layer.backgroundColor = UIColor(red: CGFloat(gameRed), green: CGFloat(gameGreen), blue: CGFloat(gameBlue), alpha: 1).cgColor
        
        timer =  Timer.scheduledTimer(timeInterval:1, target:self, selector:#selector(fireTimer), userInfo:nil, repeats:true)

    }
    
    @objc func fireTimer()
    {
        totalTime-=1
        timeLabel.text = String(totalTime)
        if(totalTime == 0)
        {
            timer.invalidate()
            displayAlert()
        }


    }
    
    func displayAlert()
    {
        let score = Int((1 - (sqrt(pow(red-gameRed, 2) + pow(green-gameGreen, 2) + pow(blue-gameBlue, 2))))*100)
        let alert = UIAlertController(title: "Game Over", message: "Score: \(score)", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Continue", style: .default){_ in self.startGame()} )
        self.present(alert, animated: true, completion: nil)
    }
}

