//
//  LogHoursViewController.swift
//  Voluntracker
//
//  Created by Vaidhyanathan, Shivansh on 12/19/23.
//

import UIKit

class LogHoursViewController: UIViewController {

    @IBOutlet var goalHoursStepper: UIStepper!
    @IBOutlet var currentHoursStepper: UIStepper!
    @IBOutlet var goalHours: UILabel!
    @IBOutlet var currentHours: UILabel!
    var username: String? = nil
    override func viewDidLoad() {
        super.viewDidLoad()
      
        guard let dict = UserDefaults.standard.dictionary(forKey: "userDict") as? [String: NSArray] else{
            return
        }
        if let inputValue = dict[username!]{
            if let userHours = inputValue.object(at: 1) as? Int {
                currentHours.text = "Current Hours: \(userHours)"
                currentHoursStepper.value = Double(userHours)
            }
            if let userGoal = inputValue.object(at: 2) as? Int{
                print(userGoal)
                goalHours.text = "Goal Hours: \(userGoal)"
                goalHoursStepper.value = Double(userGoal)
                
            }
            
        }

    }
    

    @IBAction func StepperChanged(_ sender: UIStepper) {
        if var dict = UserDefaults.standard.dictionary(forKey: "userDict") as? [String: NSArray]
        {
            if let inputValue = dict[username!]
            {
                if(sender.tag == 0)
                {
                
                    dict.updateValue([inputValue.object(at: 0),sender.value,inputValue.object(at: 2)] as NSArray, forKey: username!)
                    UserDefaults.standard.setValue(dict, forKey: "userDict")
                    currentHours.text = "Current Hours: \(sender.value)"
                    
                }
                if(sender.tag == 1)
                {
                    dict.updateValue([inputValue.object(at: 0),inputValue.object(at: 1),sender.value] as NSArray, forKey: username!)
                    UserDefaults.standard.setValue(dict, forKey: "userDict")
                    goalHours.text = "Goal Hours: \(sender.value)"
                    

                }
                
            }
           
            
       
                    
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
