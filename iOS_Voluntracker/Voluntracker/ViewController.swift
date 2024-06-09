//
//  ViewController.swift
//  Voluntracker
//
//  Created by Vaidhyanathan, Shivansh on 12/11/23.
//

import UIKit

class ViewController: UIViewController {
    let defaults = UserDefaults.standard
    
    @IBOutlet var Login: UIButton!
    @IBOutlet var username: UITextField!
    @IBOutlet var password: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        guard defaults.dictionary(forKey: "userDict") as? [String: NSArray] != nil else{
            let dict:[String: NSArray]? = nil
            defaults.set(dict, forKey: "userDict")
            return
        }
        
                
           

    }

    @IBAction func LoginPressed(_ sender: Any) {
        if let dict = defaults.dictionary(forKey: "userDict") as? [String: NSArray]
        {
            guard let user = dict[username.text!] else
            {
                invalid(field: "Username")
                return
            }
            if let pwd = user.object(at: 0) as? String{
                guard pwd == password.text! else
                {
                    invalid(field: "Password")
                    return
                }
                
            }
            
        }
                
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        guard let sender = sender as? UIButton else {return}
        if sender == Login {
            if let destinationVC = segue.destination as? LogHoursViewController {
                destinationVC.username = username.text
            }
        }
        username.text = ""
        password.text = ""
    }
    
    
    
    func invalid(field: String)
    {
        let alert = UIAlertController(title: "Error", message: "\(field) is not valid", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Continue", style: .default) )
        self.present(alert, animated: true, completion: nil)
    }
    
}

