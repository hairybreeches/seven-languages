module Day2 where

addToSortedList :: Ord a => [a] -> a -> [a]
addToSortedList list x = takeWhile (< x) list ++ [x] ++ dropWhile (<x) list

mySort :: Ord a => [a] -> [a]
mySort list = foldl addToSortedList [] list
