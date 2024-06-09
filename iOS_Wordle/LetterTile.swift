//
//  LetterTile.swift
//  Wordle
//
//  Created by Vaidhyanathan, Shivansh on 3/25/24.
//

import Foundation
import UIKit

struct LetterTile: Equatable  {
    
    static func == (lhs: LetterTile, rhs: LetterTile) -> Bool {
        lhs.letter == rhs.letter
    }
    
    
    var letter: String  = ""
    var status: Status = .incorrect
    
    
    init(letter: String, status: Status) {
        self.letter = letter
        self.status = status
    }
    
    
   
}

enum Status
{
    case correct, partial, incorrect
}
