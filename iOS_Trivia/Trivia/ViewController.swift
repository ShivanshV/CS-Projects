//
//  ViewController.swift
//  Trivia
//
//  Created by Vaidhyanathan, Shivansh on 1/17/24.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {

    var tabBarControllerItems: [UITabBarItem]?

    let categoryData: [String] = Array(Trivia.getQuestions().keys)
    let numberOfQuestions: [String] = ["1","2","3","4","5","6","7","8","9","10"]
   
    var questionSelected = false
    var numberSelected = false

    
    @IBOutlet var numberPicker: UIPickerView!
    @IBOutlet var questionType: UIPickerView!
    override func viewDidLoad() {
        super.viewDidLoad()
       

       

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        tabBarControllerItems = self.tabBarController?.tabBar.items
        
        self.questionType.delegate = self
        self.questionType.dataSource = self
        
        self.numberPicker.delegate = self
        self.numberPicker.dataSource = self
        tabBarControllerItems![1].isEnabled = false
        print(questionSelected)
        print(numberSelected)
        tabBarControllerItems![0].isEnabled = true

    }
    
    override func viewWillDisappear(_ animated: Bool) {
        questionSelected = false
        numberSelected = false

    }
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == questionType
        {
            return categoryData.count
        }
        if pickerView == numberPicker
        {
            return 10
        }
        return 0
        
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == questionType
        {
            
            return categoryData[row].replacingOccurrences(of: "Entertainment: ", with: "")
        }
        if pickerView == numberPicker
        {
            return numberOfQuestions[row]
        }
        return nil
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        let TriviaVC = self.tabBarController?.viewControllers?[1] as? TriviaViewController
        if pickerView == questionType {
            TriviaVC?.category = categoryData[row]
        
            questionSelected = true
        } else if pickerView == numberPicker {
            TriviaVC?.num_questions = Int(numberOfQuestions[row])!
            numberSelected = true
        }
        
        checkStatus()
        
        
        

    }
    
    func checkStatus()
    {

        if questionSelected && numberSelected
        {
            tabBarControllerItems![1].isEnabled = true
        }
        else
        {
            tabBarControllerItems![1].isEnabled = false
        }
    }
    
    @IBAction func unwindToSettings(unwindSegue: UIStoryboardSegue)
    {
        
    }
    
   


    

}

