//
//  ViewController.swift
//  Tip Calculator
//
//  Created by Vaidhyanathan, Shivansh on 11/3/23.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var TipAmount: UILabel!
    var amount: Double = 0
    var Tip: Double = 0.15
        
        
    
    @IBOutlet var CustomTip: UITextField!
    @IBOutlet var amountInput: UITextField!
    @IBOutlet var TipOption: UISegmentedControl!
    @IBOutlet var Total: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        CustomTip.isHidden = true;

    }

    @IBAction func tipEntered(_ sender: Any) {
        TipChanged((Any).self)
    }
    
    @IBAction func amountEntered(_ sender: UITextField) {
        amount = Double(sender.text!)!
        if TipOption.selectedSegmentIndex == 3
        {
            Total.text = "$\(String(format: "%.2f", Float(amount+Tip)))"
            TipAmount.text = "$\(String(format: "%.2f", Float(Tip)))"
        }
        else
        {
            Total.text = "$\(String(format: "%.2f", Float(amount*(1+Tip))))"
            TipAmount.text = "$\(String(format: "%.2f", Float(amount * Tip)))"
        }
       
       
    }
    @IBAction func TipChanged(_ sender: Any) {
        if TipOption.selectedSegmentIndex == 3
        {
            Tip = 0
            CustomTip.isHidden = false;
            if let tip = Double(CustomTip.text!)
            {
                Tip = tip
                Total.text = "$\(String(format: "%.2f", Float(amount+Tip)))"
                TipAmount.text = "$\(String(format: "%.2f", Float(Tip)))"
            }

        }
        else
        {
            CustomTip.isHidden = true;
            CustomTip.text = "";
            if TipOption.selectedSegmentIndex == 0
            {
                Tip = 0.15
            }
            if TipOption.selectedSegmentIndex == 1
            {
                Tip = 0.18
            }
            if TipOption.selectedSegmentIndex == 2
            {
                Tip = 0.2
            }
            Total.text = "$\(String(format: "%.2f", Float(amount*(1+Tip))))"
            TipAmount.text = "$\(String(format: "%.2f", Float(amount * Tip)))"
        }
        
        
    }
    
    @IBAction func resetButton(_ sender: Any) {
        CustomTip.isHidden = true
        TipOption.selectedSegmentIndex = 0
        Total.text = "$0.00"
        TipAmount.text = "$0.00"
        amountInput.text = ""
    }
}

