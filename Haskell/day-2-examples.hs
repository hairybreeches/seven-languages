module Day2 where

addToSortedList :: (a -> a -> Bool) -> [a] -> a -> [a]
addToSortedList sorter list x = 
  takeWhile (sorter x) list 
  ++ [x] 
  ++ dropWhile (sorter x) list
  
mySortBy :: [a] -> (a -> a -> Bool) -> [a]
mySortBy list sorter = foldl (addToSortedList sorter) [] list

mySort :: Ord a => [a] -> [a]
mySort list = mySortBy list (>)
