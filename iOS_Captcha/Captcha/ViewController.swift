//
//  ViewController.swift
//  Captcha
//
//  Created by Vaidhyanathan, Shivansh on 2/8/24.
//

import UIKit

class ViewController: UIViewController {
    var pictures = [String]()
    var correct: String!
    var tries = 0
    @IBOutlet var correctLabel: UILabel!
    @IBOutlet var CaptchaImages: [CaptchaImageView]!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let fm = FileManager.default
        let path = Bundle.main.resourcePath!
        let items = try! fm.contentsOfDirectory(atPath: path)

        for item in items {
            if item.contains(".png") {
                pictures.append(item)
            }
        }
        print(pictures)
        shuffle()
        


        // Do any additional setup after loading the view.
    }
    
    @IBAction func CaptchaClicked(_ sender: UITapGestureRecognizer) {
        if let tappedImageView = sender.view as? UIImageView as? CaptchaImageView{
            if(tappedImageView.accessibilityIdentifier == correct)
            {
                performSegue(withIdentifier: "AudioCaptcha", sender: nil)

            }
            else
            {
               
                tappedImageView.shake()
                tries+=1
                shuffle()
               
            }
       }
    }
    
    func shuffle()
    {
        if tries < 2
        {
            pictures.shuffle()
            for i in 0...3 {
                CaptchaImages[i].image = UIImage(named: pictures[i])
                CaptchaImages[i].accessibilityIdentifier = pictures[i]
            }
             correct = pictures[Int(arc4random_uniform(4))]
            correctLabel.text = "Tap the image with text: \n \(correct.replacingOccurrences(of: ".png", with: ""))"
        }
        else
        {
            performSegue(withIdentifier: "Loser", sender: nil)
        }
        
    }
    


}

