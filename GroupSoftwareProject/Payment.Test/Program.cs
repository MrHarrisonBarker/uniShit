using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using Stripe;

namespace Payment.Test
{
    class Program
    {
        static async Task Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            StripeConfiguration.ApiKey =
                "sk_test_51ILW9dK2ugLXrgQXeYfqg8i0QGAgLXndihLXovHgu47adBimPAedvIwzfr95uffR9TiyleGFAPY7hfSI9mhdmYBF00hkxlAQMv";
            
            string accountId = "acct_1Hwvx44ICPI34MBa";
            string customerId = "cus_IY2t29dSELhwSK";
            string cardId = "card_1HwwsQKzP2k6dDDPmLIFCeIc";

            // var options = new AccountCreateOptions
            // {
            //     Type = "custom",
            //     Country = "GB",
            //     Email = "mail@harrisonbarker.co.uk",
            //     BusinessType = "individual",
            //     Capabilities = new AccountCapabilitiesOptions
            //     {
            //         CardPayments = new AccountCapabilitiesCardPaymentsOptions {Requested = true},
            //         Transfers = new AccountCapabilitiesTransfersOptions {Requested = true},
            //         
            //     },
            //     Individual = new AccountIndividualOptions()
            //     {
            //         Email = "mail@harrisonbarker.co.uk",
            //         Address = new AddressOptions()
            //         {
            //             PostalCode = "ip146sl",
            //             City = "Lol",
            //             Country = "GB",
            //             Line1 = "Wally way",
            //             Line2 = "Dobenham"
            //         },
            //         Dob = new DobOptions()
            //         {
            //             Day = 1,
            //             Month = 1,
            //             Year = 2000
            //         },
            //         FirstName = "Joe",
            //         LastName = "Bloggs",
            //         Phone = "+440000000000"
            //     },
            //     TosAcceptance = new AccountTosAcceptanceOptions()
            //     {
            //         Date = DateTime.Now,
            //         Ip = "127.0.0.1"
            //     }
            // };
            //
            // var service = new AccountService();
            // Account account = await service.CreateAsync(options);
            // Console.WriteLine(account);

            // acct_1Hwvx44ICPI34MBa

            // Console.WriteLine(await service.UpdateAsync("acct_1HwvZw4ENnvy1giK", new AccountUpdateOptions()
            // {
            //     TosAcceptance = new AccountTosAcceptanceOptions()
            //     {
            //         Date = DateTime.Now,
            //         Ip = "127.0.0.1"
            //     }
            // }));

            // var cardService = new CardService();
            // Console.WriteLine(await cardService.GetAsync("cus_IY2t29dSELhwSK","card_1HwwsQKzP2k6dDDPmLIFCeIc"));

            // var s = new ExternalAccountService();
            // ExternalAccountCreateOptions accountCreateOptions = new ExternalAccountCreateOptions
            // {
            //     ExternalAccount = 
            // };
            // var externalAccount = await s.CreateAsync("acct_1Hx1Yt3rCdU4mXVY", accountCreateOptions);
            // Console.WriteLine(externalAccount);

            var service = new PaymentIntentService();
            
            var intent = await service.CreateAsync(new PaymentIntentCreateOptions()
            {
                Amount = 100,
                Currency = "gbp",
                PaymentMethodTypes = new List<string>
                {
                    "card",
                },
                OnBehalfOf = "acct_1IMZdt2fJrKfCTmZ",
                Customer = "cus_IybZSKDCedhn0K",
                ConfirmationMethod = "automatic",
                ApplicationFeeAmount = 10,
                TransferData = new PaymentIntentTransferDataOptions()
                {
                    Destination = "acct_1IMZdt2fJrKfCTmZ"
                }
            });
            
            var paymentConfirmation = await service.ConfirmAsync(intent.Id,new PaymentIntentConfirmOptions()
            {
                PaymentMethod = "card_1IMeMHK2ugLXrgQXkGPh7iTJ",
                
            });
            
            Console.WriteLine(paymentConfirmation);
        }
    }
}