#checs to determine if user is instructor, returns 1 if true#
Select if(uca is not null, 1, 0) as NewResult
From instructor
where uca = "tdevine"