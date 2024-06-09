//
//  ResultsViewController.swift
//  Trivia
//
//  Created by Vaidhyanathan, Shivansh on 1/31/24.
//

import UIKit

class ResultsViewController: UIViewController {

    var points: Int = 0
    var num_questions: Int = 0
    @IBOutlet var finalMessage: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        finalMessage.text = "You scored \(points) / \(num_questions) points!"

        // Do any additional setup after loading the view.
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
