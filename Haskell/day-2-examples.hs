module Day2 where

import Data.Char

addToSortedList :: (a -> a -> Bool) -> [a] -> a -> [a]
addToSortedList sorter list x = 
  takeWhile (sorter x) list 
  ++ [x] 
  ++ dropWhile (sorter x) list
  
mySortBy :: [a] -> (a -> a -> Bool) -> [a]
mySortBy list sorter = foldl (addToSortedList sorter) [] list

mySort :: Ord a => [a] -> [a]
mySort list = mySortBy list (>)


readDecimalString :: String -> Int -> Double 
readDecimalString [] decimalPlace = 0
readDecimalString (h:t) decimalPlace = (readDecimalString t (decimalPlace + 1)) + fromIntegral (digitToInt h) * 10 ** fromIntegral (-1 * decimalPlace)

readMoneyStringIterator :: String -> Double -> Double 
readMoneyStringIterator [] soFar = soFar
readMoneyStringIterator (h:t) soFar
  | isDigit h = readMoneyStringIterator t (10 * soFar + fromIntegral (digitToInt h))
  | h == '.' = soFar + readDecimalString t 1
  | otherwise = readMoneyStringIterator t soFar
  
readMoneyString :: String -> Double 
readMoneyString string = readMoneyStringIterator string 0

everyThird :: Int -> [Int]
everyThird x = [x, x+3..]

everyFifth :: Int -> [Int]
everyFifth x = [x, x+5..]

everyEighth :: Int -> Int -> [Int]
everyEighth x y = zipWith (+) (everyThird x) (everyFifth y)

halve :: Double -> Double
halve = (/2)

appendNewLine :: String -> String
appendNewLine = (++ "\n")
  
