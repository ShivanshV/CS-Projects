//
//  SoundViewController.swift
//  Captcha
//
//  Created by Vaidhyanathan, Shivansh on 2/20/24.
//

import UIKit
import AVFoundation

class SoundViewController: UIViewController {
    var sounds = [String]()
    var correct: String!
    var tries = 0
    var player: AVAudioPlayer?

    @IBOutlet var CaptchaButtons: [CaptchaButton]!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let fm = FileManager.default
        let path = Bundle.main.resourcePath!
        let items = try! fm.contentsOfDirectory(atPath: path)
        
        for item in items {
            if item.contains(".wav") {
                sounds.append(item)
            }
        }
        print(sounds)
        shuffle()
    }

    @IBAction func soundClicked(_ sender: Any) {
        print(correct!)
        guard let path = Bundle.main.path(forResource: correct!.replacingOccurrences(of: ".wav", with: ""), ofType: "wav") else { return }
                let url = URL(fileURLWithPath: path)

                do {
                    player = try AVAudioPlayer(contentsOf: url)
                    player?.play()
                } catch {
                    print("Could not play sound: \(error.localizedDescription)")
                }

    }
    @IBAction func CaptchaClicked(_ sender: CaptchaButton) {
        if(correct.contains(sender.title(for: .normal)!))
        {
            performSegue(withIdentifier: "win", sender: nil)

        }
        else
        {
            
            sender.shake()
            tries+=1
            shuffle()
        }
    }
    
    func shuffle()
    {
        if tries < 2
        {
            sounds.shuffle()
            for i in 0...3 {
                if let underscoreIndex = sounds[i].firstIndex(of: "_") {
                    let startIndex = sounds[i].index(after: underscoreIndex)
                    let substring = sounds[i][startIndex...]
                    CaptchaButtons[i].setTitle(String(substring).replacingOccurrences(of: ".wav", with: ""), for: .normal)
                }
            }
             correct = sounds[Int(arc4random_uniform(4))]
        }
        else
        {
            performSegue(withIdentifier: "Loser", sender: nil)
        }
        
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
