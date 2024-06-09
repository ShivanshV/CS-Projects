//
//  AddItemViewController.swift
//  Mynance
//
//  Created by Vaidhyanathan, Shivansh on 4/19/24.
//

import UIKit

class AddItemViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    let categories = ["Income", "Groceries", "Utilities"]
    var transaction: Transaction = Transaction(category: "nill", item: "nill", price: "0.00", date: "date")

    @IBOutlet var descriptionField: UITextField!
    @IBOutlet var priceField: UITextField!
    @IBOutlet var categoryPicker: UIPickerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.categoryPicker.delegate = self
        self.categoryPicker.dataSource = self
        // Do any additional setup after loading the view.
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return categories.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        
            return categories[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        transaction.category = categories[row]
        
    }

    
    @IBAction func priceChanged(_ sender: UITextField) {
        
            transaction.price = sender.text!
        
    }
    
    @IBAction func itemChanged(_ sender: UITextField) {
            transaction.item = sender.text!
   
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
