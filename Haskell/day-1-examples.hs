module Main where

main :: IO ()
main = return ()

double x = x + x

factorial :: Integer -> Integer
factorial 0 = 1
factorial x = x* factorial(x-1)

guardedfactorial :: Integer -> Integer
guardedfactorial x
  | x > 1 = x* factorial(x-1)
  | otherwise = 1
  
fibTuple :: (Integer, Integer, Integer) -> (Integer, Integer, Integer)
fibTuple (x,y,0) = (x,y,0)
fibTuple (x, y, index) = fibTuple(y, x+y, index-1)

fibResult :: (Integer, Integer, Integer) -> Integer
fibResult (x,y,z) = x

fib :: Integer -> Integer
fib x = fibResult(fibTuple(0,1,x))

allEven0 :: [Integer] -> [Integer]
allEven0 [] = []
allEven0 (h:t) 
  | even h = h : allEven0 t
  | otherwise = allEven0 t

allEven1 :: [Integer] -> [Integer]
allEven1 list = [x | x <- list, even x]

allEven2 :: [Integer] -> [Integer]
allEven2 list = filter even list

myreverse [] = []
myreverse (h:t) = reverse t ++ [h]

pairs list = [(x,y) | x <- list, y <- list, x < y]

multiplication max = [ (x,y,x*y) | x<-[1 .. max], y <- [1..max]]

colourmap colours = [(alabama, florida, georgia, mississippi, tennessee) | 
  alabama <- colours, 
  florida <- colours, 
  georgia <- colours, 
  mississippi <- colours, 
  tennessee <- colours, 
  mississippi /= tennessee, 
  mississippi /= alabama, 
  alabama /= tennessee, 
  alabama /= mississippi, 
  alabama /= georgia, 
  alabama /= florida, 
  georgia /= florida, 
  georgia /= tennessee]
 