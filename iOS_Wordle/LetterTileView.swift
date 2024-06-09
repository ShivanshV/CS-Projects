//
//  LetterTileView.swift
//  Wordle
//
//  Created by Vaidhyanathan, Shivansh on 3/27/24.
//

import Foundation
import UIKit

class LetterTileView: UILabel
{
    var letterTile: LetterTile?
    
   
    
    func changeColor()
    {
        if(letterTile?.status == .correct)
        {
            self.backgroundColor = .green
        }
        else if(letterTile?.status == .partial)
        {
            self.backgroundColor = .yellow
        }
    }
    
    
}
