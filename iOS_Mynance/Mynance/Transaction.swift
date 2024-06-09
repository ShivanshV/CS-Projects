//
//  Transaction.swift
//  Mynance
//
//  Created by Vaidhyanathan, Shivansh on 4/19/24.
//

import Foundation

struct Transaction: Codable
{
 
    
   
    
    var category: String
    var item: String
    var price: String
    var date: String
    
    init(category: String, item: String, price: String, date: String) {
        self.category = category
        self.item = item
        self.price = price
        self.date = date
    }
    
   
}
