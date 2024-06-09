//
//  TransactionCell.swift
//  Mynance
//
//  Created by Vaidhyanathan, Shivansh on 4/19/24.
//

import Foundation
import UIKit

class TransactionCell: UITableViewCell {
    @IBOutlet var icon: UIImageView!
    @IBOutlet var category: UILabel!
    @IBOutlet var item: UILabel!
    @IBOutlet var price: UILabel!
    @IBOutlet var date: UILabel!
    
    func configure()
    {
        icon.backgroundColor = .systemBlue
        icon.layer.cornerRadius = 8
        icon.clipsToBounds = true
        
        if category.text == "Income"
        {
            icon.image = UIImage(systemName: "dollarsign")
        }
        if category.text == "Groceries"
        {
            icon.image = UIImage(systemName: "cart")

        }
        
        if category.text == "Utilities"
        {
            icon.image = UIImage(systemName: "lightbulb")

        }
    }
    
}
