(setq animals '(gazelle giraffe lion tiger))

(reverse animals)

(defun reverse-list-with-while (list)
  (let (value)
    (while list
      (setq value (cons (car list) value))
      (setq list (cdr list)))
    value))
(reverse-list-with-while animals)

(defun reverse-list-with-dolist (list)
  (let (value)
    (dolist (element list value)
      (setq value (cons element value)))))
(reverse-list-with-dolist animals)
