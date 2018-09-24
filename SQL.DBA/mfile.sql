CREATE TABLE parent (
    id INT  PRIMARY KEY,
     
); 

CREATE TABLE child (
    id INT, 
    parent_id INT,
    
constraint fk_fo FOREIGN KEY (parent_id) 
        REFERENCES parent(id)
        ON DELETE CASCADE
) ;