#returns 1 if uca and password combination is located #
Select if( uca is not null  , 1, 0) as NewResult
From users
where uca = "ucaInput" and password = "passwordInput"
