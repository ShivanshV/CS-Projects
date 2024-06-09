//
//  TriviaViewController.swift
//  Trivia
//
//  Created by Vaidhyanathan, Shivansh on 1/25/24.
//

import UIKit

class TriviaViewController: UIViewController {

    @IBOutlet var progressBar: UIProgressView!
    @IBOutlet var CategoryLabel: UILabel!
    
    var tabBarControllerItems: [UITabBarItem]?

    var category: String = ""
    var num_questions: Int = 0
    var questions_answered: Int!
    var questions:[Trivia]?
    var correctAnswer: String!
    var points: Int!

    @IBOutlet var Option4: UIButton!
    @IBOutlet var Option3: UIButton!
    @IBOutlet var Option2: UIButton!
    @IBOutlet var Option1: UIButton!
    @IBOutlet var currentQuestionText: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        

        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        tabBarControllerItems = self.tabBarController?.tabBar.items
        questions_answered = 0
        CategoryLabel.text = category
        questions = Trivia.getQuestions()[category]!
        assignQuestion()
        tabBarControllerItems![0].isEnabled = false
        progressBar.setProgress(0, animated: true)
        points = 0
    }
    func assignQuestion()
    {
        Option1.backgroundColor = .lightGray
        Option2.backgroundColor = .lightGray
        Option3.backgroundColor = .lightGray
        Option4.backgroundColor = .lightGray

        let question = questions?.randomElement()
        currentQuestionText.text = question?.q
        correctAnswer = question!.correct
        var options: [String] = [correctAnswer] + question!.incorrect
        options.shuffle()
        for tag in 1...4{
            if let button = view.viewWithTag(tag) as? UIButton
            {
                button.setTitle(options[tag-1], for: .normal)
            }
        }
    }
    

    @IBAction func OptionClicked(_ sender: UIButton) {
        var correct = false
        questions_answered+=1
        progressBar.setProgress(Float(questions_answered) / Float(num_questions), animated: true)
        if(sender.title(for: .normal) == correctAnswer)
        {
            
            correct = true
            points+=1
            
        }
        
            UIView.animate(withDuration: 0.8, animations: {
                if correct{
                    sender.backgroundColor = .green

                }
                else
                {
                    sender.backgroundColor = .red
                }
            }, completion: { _ in
                if(self.questions_answered < self.num_questions)
                {
                    self.assignQuestion()
                }
                else
                {
                    self.performSegue(withIdentifier: "Result", sender: nil)
                }
            }
            )
            
        
       
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destinationVC = segue.destination as? ResultsViewController {
            destinationVC.points = points
            destinationVC.num_questions = num_questions
        }
    }
 
    
}
