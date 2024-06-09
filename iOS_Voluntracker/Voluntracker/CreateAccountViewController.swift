//
//  CreateAccountViewController.swift
//  Voluntracker
//
//  Created by Vaidhyanathan, Shivansh on 12/15/23.
//

import UIKit

class CreateAccountViewController: UIViewController {

    @IBOutlet var statusText: UILabel!
    @IBOutlet var pwdStack: UIStackView!
    var username: String = ""
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    @IBAction func usernameEntered(_ sender: UITextField) {
        if let dict = UserDefaults.standard.dictionary(forKey: "userDict") as? [String: NSArray]
        {
            guard dict[sender.text!] == nil else
            {
                pwdStack.isHidden = true
                statusText.text = "Username Taken"
                return
            }
            statusText.text = ""
            
        }
        pwdStack.isHidden = false
        username = sender.text!
    }
    @IBAction func passwordEntered(_ sender: UITextField) {
        if var dict = UserDefaults.standard.dictionary(forKey: "userDict") as? [String: NSArray]
        {
            guard sender.text != "" else
            {
                statusText.text = "Password cannot be empty"
                return
            }
            dict.updateValue([sender.text!,0,0] as NSArray, forKey: username)
            UserDefaults.standard.setValue(dict, forKey: "userDict")
            statusText.text = "Account Created!"
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
