module Day3 where

import qualified Data.Map.Strict as Map

type BadAssLookup = Map.Map Int (Map.Map Int (Map.Map Int (Map.Map Int String)))

exampleLookup :: BadAssLookup
exampleLookup = Map.fromList
    [ 
        (0, Map.fromList [
            (1, Map.singleton 0 (Map.singleton 1 "New year")), 
            (2, Map.singleton 0 (Map.singleton 5 "May day (replacement)"))]),
        
        (2, Map.fromList [
            (5, Map.singleton 0 (Map.singleton 3 "Good Friday")), 
            (6, Map.singleton 1 (Map.singleton 2 "Boxing day")),
            (7, Map.singleton 1 (Map.singleton 2 "Christmas day (replacement)")),
            (8, Map.singleton 0 (Map.singleton 3 "Easter Monday"))]),
        
        (3, Map.singleton 0 (Map.singleton 0 (Map.singleton 5 "Spring")))]
        
getChristmasDay :: BadAssLookup -> Maybe String
getChristmasDay lookup = Map.lookup 2 lookup >>= Map.lookup 5 >>= Map.lookup 1 >>= Map.lookup 2

getChristmasDayReplacement :: BadAssLookup -> Maybe String
getChristmasDayReplacement lookup = Map.lookup 2 lookup >>= Map.lookup 7 >>= Map.lookup 1 >>= Map.lookup 2

