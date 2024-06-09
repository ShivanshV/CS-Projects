//
//  TransactionViewController.swift
//  Mynance
//
//  Created by Vaidhyanathan, Shivansh on 4/15/24.
//

import UIKit

class TransactionViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
  
    
    var TransactionArray: [Transaction] = []
    let userDefaults = UserDefaults.standard

    var balance: Double = 0
    @IBOutlet var tableview: UITableView!
    @IBOutlet var balanceText: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableview.delegate = self
        tableview.dataSource = self
        if let savedAccount = userDefaults.object(forKey: "TransactionArray") as? Data{
            let decoder = JSONDecoder()
            if let loaded = try? decoder.decode([Transaction].self, from: savedAccount)
            {
                balance = userDefaults.double(forKey: "balance")
                balanceText.text = "$\(balance)"
                TransactionArray = loaded
                
                tableview.reloadData()
            }
            
        } else {
            print("Failed to encode TransactionArray")
        }
      



        // Do any additional setup after loading the view.
    }
    

    /*
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    


    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        TransactionArray.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell:TransactionCell = tableView.dequeueReusableCell(withIdentifier: "transaction", for: indexPath) as! TransactionCell
        let arrayItem = TransactionArray[indexPath.row]
        cell.category.text = arrayItem.category
        cell.item.text = arrayItem.item
        cell.price.text = arrayItem.price
        cell.date.text = arrayItem.date
        cell.configure()
        return cell
        

    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 65.0;
    }
    @IBAction func unwindToTransaction(_ unwindSegue: UIStoryboardSegue) {
        
        
        let sourceViewController = unwindSegue.source as? AddItemViewController
        let doublePrice = Double(sourceViewController!.transaction.price.filter("0123456789.".contains))!
        if sourceViewController!.transaction.category != "Income"
        {
            sourceViewController!.transaction.price = "-\(sourceViewController!.transaction.price)"
            balance = balance - doublePrice
        }
        else
        {
            balance = balance + doublePrice
        }
        balanceText.text = "$\(balance)"
        
        let today = Date.now
        let format = DateFormatter()
        format.dateFormat = "HH:mm E, d MMM y"
        sourceViewController!.transaction.date = format.string(from: today)


        print(sourceViewController!.transaction)
       

        TransactionArray.append(sourceViewController!.transaction)
        tableview.reloadData()
        let encoder = JSONEncoder()
        if let data = try? encoder.encode(TransactionArray)
        {
            userDefaults.set(data, forKey: "TransactionArray")
            userDefaults.set(balance, forKey: "balance")
        }
        print(TransactionArray)
        // Use data from the view controller which initiated the unwind segue
    }

}
