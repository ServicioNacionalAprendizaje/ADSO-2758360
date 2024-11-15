inventory
    category
        code
        name
        description
    product
        code
        name
        description
        category_id
    inventory
        stock
        purchase_value
        sale_value
        product_id
        branch_id
        date

supplier
    company
        nit
        name
        address
        email
        phone
        manager_id => Es id de la persona
    branch
        name
        address
        email
        phone
        responsible_id  => Es id de la persona
        company_id

billing

    invoice
        date
        gross_value
        net_value
        discount_value
        payment_method_id
    invoice_detail
        gross_value
        net_value
        discount_percentage
        quantity
        product_id
    payment_method
        code
        name
        description