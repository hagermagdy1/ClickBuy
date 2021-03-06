package com.example.clickbuy.models

data class Orders (
    val orders: List<Order>
)
data class OrderPojo(
    var order:Order
)
data class Addresses (
    val addresses: List<Address>
)
data class Order (
    val admin_graphql_api_id: String? = null,
    val app_id: Int? = null,
    var billing_address: CustomerAddress? = null,
    val browser_ip: Any? = null,
    val buyer_accepts_marketing: Boolean? = null,
    val cancel_reason: Any? = null,
    val cancelled_at: Any? = null,
    val cart_token: Any? = null,
    val checkout_id: Any? = null,
    val checkout_token: Any? = null,
    val closed_at: Any? = null,
    val confirmed: Boolean? = null,
    val contact_email: String? = null,
    val created_at: String? = null,
    val currency: String? = null,
    val current_subtotal_price: String? = null,
    val current_subtotal_price_set: Set? = null,
    val current_total_discounts: String? = null,
    val current_total_discounts_set: Set? = null,
    val current_total_duties_set: Any? = null,
    val current_total_price: String? = null,
    val current_total_price_set: Set? = null,
    val current_total_tax: String? = null,
    val current_total_tax_set: Set? = null,
    val customer: Customer? = null,
    val customer_locale: Any? = null,
    val device_id: Any? = null,
    val discount_applications: List<Any>? = null,
    var discount_codes: List<DiscountCodes>? = null,
    var email: String? = null,
    val estimated_taxes: Boolean? = null,
    val financial_status: String? = null,
    val fulfillment_status: Any? = null,
    val fulfillments: List<Any>? = null,
    val gateway: String? = null,
    val id: Long? = null,
    val landing_site: Any? = null,
    val landing_site_ref: Any? = null,
    var line_items: List<BagItem>? = null,
    val location_id: Any? = null,
    val name: String? = null,
    val note: String? = null,
    var note_attributes: List<NoteAttribute>? = null,
    val number: Int? = null,
    val order_number: Int? = null,
    val order_status_url: String? = null,
    val original_total_duties_set: Any? = null,
    val payment_gateway_names: List<Any>? = null,
    val payment_terms: Any? = null,
    val phone: Any? = null,
    val presentment_currency: String? = null,
    val processed_at: String? = null,
    val processing_method: String? = null,
    val reference: Any? = null,
    val referring_site: Any? = null,
    val refunds: List<Any>? = null,
    val shipping_address:Address? = null,
    val shipping_lines: List<Any>? = null,
    val source_identifier: Any? = null,
    val source_name: String? = null,
    val source_url: Any? = null,
    val subtotal_price: String? = null,
    val subtotal_price_set: Set? = null,
    val tags: String? = null,
    val tax_lines:  List<Any?>? = null,
    val taxes_included: Boolean? = null,
    val test: Boolean? = null,
    val token: String? = null,
    val total_discounts: String? = null,
    val total_discounts_set: Set? = null,
    val total_line_items_price: String? = null,
    val total_line_items_price_set: Set? = null,
    val total_outstanding: String? = null,
    val total_price: String? = null,
    val total_price_set: Set? = null,
    val total_price_usd: String? = null,
    val total_shipping_price_set: Set? = null,
    val total_tax: String? = null,
    val total_tax_set: Set? = null,
    val total_tip_received: String? = null,
    val total_weight: Int? = null,
    val updated_at: String? = null,
    val user_id: Any? = null,
)

data class Address (
    val first_name: String?= null,
    val address1: String?= null,
    val phone: String?= null,
    val city: String?= null,
    val zip: String?= null,
    val province: String?= null,
    val country: String?= null,
    val last_name: String?= null,
    val address2: Any? = null,
    val company: Any? = null,
    val latitude: Any? = null,
    val longitude: Any? = null,
    val name: String?= null,
    val country_code: String?= null,
    val province_code: Any? = null,
    val id: Long? = null,
    val customer_id: Long? = null,
    val country_name: String? = null,
    val default: Boolean? = null
)

data class Set (
    val shop_money: Money,
    val presentment_money: Money
)

data class Money (
    val amount: String,
    val currency_code: String,
    val email: String,

    )

data class OrderCustomer (
    val id: Long,
    val email: String,
    val accepts_marketing: Boolean,
    val created_at: String,
    val updated_at: String,
    val first_name: String? = null,
    val last_name: String? = null,
    val orders_count: Long,
    val state: String,
    val total_spent: String,
    val last_order_id: Long,
    val note: String? = null,
    val verified_email: Boolean,
    val multipass_identifier: Any? = null,
    val tax_exempt: Boolean,
    val phone: String? = null,
    val tags: String,
    val last_order_name: String,
    val currency: String,
    val accepts_marketing_updated_at: String,
    val marketing_opt_in_level: Any? = null,
    val tax_exemptions: List<Any?>,
    val email_marketing_consent: MarketingConsent? = null,
    val sms_marketing_consent: MarketingConsent? = null,
    val admin_graphql_api_id: String,
    val default_address: Address? = null
)

data class MarketingConsent (
    val state: String,
    val opt_in_level: String,
    val consent_updated_at: Any? = null,
    val consent_collected_from: String? = null
)

data class LineItem (
    val id: Long? = null,
    val admin_graphql_api_id: String? = null,
    val fulfillable_quantity: Long? = null,
    val fulfillment_service: String? = null,
    val fulfillmentStatus: Any? = null,
    val gift_card: Boolean? = null,
    val grams: Long? = null,
    val name: String? = null,
    val price: String? = null,
    val price_set: Set? = null,
    val product_exists: Boolean? = null,
    val product_id: Long? = null,
    val properties: List<Any?>? = null,
    val quantity: Long? = null,
    val requires_shipping: Boolean? = null,
    val sku: String? = null,
    val taxable: Boolean? = null,
    val title: String? = null,
    val total_discount: String? = null,
    val total_discount_set: Set? = null,
    val variant_id: Long? = null,
    val variant_inventory_management: String? = null,
    val variant_title: String? = null,
    val vendor: String? = null,
    val tax_lines: List<Any?>? = null,
    val duties: List<Any?>? = null,
    val discount_allocations: List<Any?>? = null
)
data class ItemImage(var name : String,
                      var value : String){
}

data class DiscountCodes(
    var code: String? = "",
    var amount: String? = "",
    var type: String? = ""
)