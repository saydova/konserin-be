Table users {
  id int [pk, increment]
  name varchar
  email varchar [unique]
  password varchar
  role varchar // ADMIN, EVENT_ORGANIZER, USER
  created_at timestamp
  updated_at timestamp
}

Table user_balances {
  id int [pk, increment]
  user_id int [ref: > users.id]
  balance decimal
  updated_at timestamp
}

Table events {
  id int [pk, increment]
  organizer_id int [ref: > users.id]
  name varchar
  description text
  date datetime
  venue varchar
  image_url varchar
  is_deleted boolean [default: false]
  created_at timestamp
  updated_at timestamp
}

Table ticket_types {
  id int [pk, increment]
  event_id int [ref: > events.id]
  name varchar // REGULAR, VIP, VVIP
  price decimal
  stock int
  is_deleted boolean [default: false]
  created_at timestamp
  updated_at timestamp
}

Table tickets {
  id int [pk, increment]
  user_id int [ref: > users.id]
  ticket_type_id int [ref: > ticket_types.id]
  qty int
  total_price decimal
  status varchar // PENDING, PAID, EXPIRED
  payment_id int [ref: > payments.id]
  expired_at timestamp
  created_at timestamp
}

Table top_ups {
  id int [pk, increment]
  user_id int [ref: > users.id]
  amount decimal
  status varchar // PENDING, PAID, FAILED
  payment_id int [ref: > payments.id]
  created_at timestamp
}

Table payments {
  id int [pk, increment]
  user_id int [ref: > users.id]
  type varchar // TICKET, TOP_UP
  reference_id int
  method varchar // SALDO, MIDTRANS
  amount decimal
  status varchar // PENDING, PAID, FAILED
  midtrans_order_id varchar
  midtrans_token varchar
  paid_at timestamp
  created_at timestamp
}
