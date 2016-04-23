#returns 1 if UCA and assesmentName combination is located #
Select if( uca is not null  , 1, 0) as NewResult
From answers
where uca = ? and assessmentName = ?
