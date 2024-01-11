import React, { useState, useEffect, useRef  } from 'react';
import { Link, NavLink, useNavigate, useParams }  from 'react-router-dom';
import IconFile from '../../../components/Icon/IconFile';
import IconTrashLines from '../../../components/Icon/IconTrashLines';
import axios from 'axios';


const index = () => {
    const [company_name,setComName]=useState("");
    const [com_short_name,setComStName]=useState("");
    const [com_email,setComEmail]=useState("");
    const [com_phone,setComPhone]=useState("");
    const [login_logo, setLoginLogo] = useState<File | null>(null);
    const [com_address,setComAddress]=useState("");
    const [com_country,setComCountry]=useState("");
    const [com_tin,setComTin]=useState("");
    const [com_bin,setComBin]=useState("");
    const [com_bank,setComBank]=useState("");
    const [com_b_branch,setComBnkBranch]=useState("");
    const [com_acc_no,setComAccNo]=useState("");
    const [invoice_logo, setInvoiceLogo] = useState<File | null>(null);
    const [com_currency,setComCurrency]=useState("");
    const [com_buss_nature,setComBussNature]=useState("");
    const [com_buss_eco,setComBussEco]=useState("");
    const [com_auth_person,setComAuthPerson]=useState("");
    const [com_vat_type,setComVatType]=useState("");
    const [com_status,setComStatus]=useState("");



    interface authorisedPerson {
        // Define the structure of your require
        id: number;
        personName: string;
      }
    const [initialRecords, setInitialRecords] = useState<authorisedPerson[]>([]);



    const params = useParams();
    const navigate = useNavigate();

    const getCompanyDetails = async()=>{
        const token = localStorage.getItem('Token');
        if(token){
            const bearer = JSON.parse(token);
            const headers= { Authorization: `Bearer ${bearer}`, 'Content-Type': 'multipart/form-data' }

            const c_id = 1;

        await axios.get(`http://localhost:8080/bmitvat/api/company/get-company/${c_id}`,{headers})
            .then((response) => {
                const data = response.data;
                // console.log(data);
                setComName(data.companyName)
                setComStName(data.comSortName)
                setComEmail(data.comEmail)
                setComPhone(data.comPhone)
                setLoginLogo(data.loginLogo)
                setComAddress(data.street)
                setComCountry(data.countryId)
                setComTin(data.comTin)
                setComBin(data.comBin)
                setComBank(data.comBank)
                setComBnkBranch(data.comBankBranch)
                setComAccNo(data.comBankAcc)
                setInvoiceLogo(data.invoiceLogo)
                setComCurrency(data.comCurrency)
                setComBussNature(data.businessNature)
                setComBussEco(data.businessEconomics)
                setComAuthPerson(data.authorisedPersonId)
                setComVatType(data.vatType)
                setComStatus(data.status)

            })
            .catch((error) => {
                console.error('Error fetching data:', error);

            });

            // for Authorised Person
        await axios.get('http://localhost:8080/bmitvat/api/authorised_person/all_person',{headers})
            .then((response) => {
                setInitialRecords(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);

            });
        }

        // console.log(initialRecords);

    }

    useEffect(()=>{
        getCompanyDetails();   
    },[])  

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const isFile1 = invoice_logo instanceof File;
        const isFile = login_logo instanceof File;
        console.log(isFile);
        if(isFile && isFile1){

            const company = {
            companyName: company_name,
            comSortName:com_short_name,
            comEmail: com_email,
            comPhone: com_phone,
            loginLogo: login_logo,
            street: com_address,
            countryId: com_country,
            comTin: com_tin,
            comBin: com_bin,
            comBank: com_bank,
            comBankBranch: com_b_branch,
            comBankAcc: com_acc_no,
            invoiceLogo: invoice_logo,
            comCurrency: com_currency,
            businessNature: com_buss_nature,
            businessEconomics: com_buss_eco,
            authorisedPersonId: com_auth_person,
            vatType: com_vat_type,
            status: com_status,
            }
        
        const token = localStorage.getItem('Token');
        if(token){
            const bearer = JSON.parse(token);
            const headers= { Authorization: `Bearer ${bearer}`, 'Content-Type': 'multipart/form-data' }
            const c_id = 1;

        try {
            // console.log(company);
           await axios.put(`http://localhost:8080/bmitvat/api/company/update-company/${c_id}`, company, {headers})
          .then(function (response){
            if(response.status== 200){
              alert("Update Successfull");
            }
          })

        } catch (err) {
          console.log(err);
        }
      }

      }else{ 

                const login_file = document.getElementById('login_file') as HTMLInputElement;
                const invoice_file = document.getElementById('invoice_file') as HTMLInputElement;
                if (login_file && invoice_file) {
                    const src = login_file.src;
                    const img_name1=src.split('/').pop();
            
                    const response1 = await fetch(src);
                    const blob1 = await response1.blob();
                    const fileExtension1 = src.split('.').pop() || 'jpg';
                    const logo_file1 = new File([blob1], `${img_name1}`, { type: `image/${fileExtension1}` });
            
            
                    const src2 = invoice_file.src;
                    const img_name2=src2.split('/').pop();
            
                    const response2 = await fetch(src2);
                    const blob2 = await response2.blob();
                    const fileExtension2 = src2.split('.').pop() || 'jpg';
                    const invoice_file2 = new File([blob2], `${img_name2}`, { type: `image/${fileExtension2}` });

                const company = {
                    companyName: company_name,
                    comSortName:com_short_name,
                    comEmail: com_email,
                    comPhone: com_phone,
                    loginLogo: logo_file1,
                    street: com_address,
                    countryId: com_country,
                    comTin: com_tin,
                    comBin: com_bin,
                    comBank: com_bank,
                    comBankBranch: com_b_branch,
                    comBankAcc: com_acc_no,
                    invoiceLogo: invoice_file2,
                    comCurrency: com_currency,
                    businessNature: com_buss_nature,
                    businessEconomics: com_buss_eco,
                    authorisedPersonId: com_auth_person,
                    vatType: com_vat_type,
                    status: com_status,
                    }
                
                const token = localStorage.getItem('Token');
                if(token){
                    const bearer = JSON.parse(token);
                    const headers= { Authorization: `Bearer ${bearer}`, 'Content-Type': 'multipart/form-data' }
                    const c_id = 1;

                try {
                    // console.log(company);
                await axios.put(`http://localhost:8080/bmitvat/api/company/update-company/${c_id}`, company, {headers})
                .then(function (response){
                    if(response.status== 200){
                    alert("Update Successfull");
                    }
                })

                } catch (err) {
                console.log(err);
                }

            }

            }


        }



      };






    return (
        <div>
            <div className="panel flex items-center justify-between flex-wrap gap-4">
                <h2 className="text-xl font-bold">Company Settings</h2>
            </div>
            <div className="panel mt-6">
                {/*---------------- Company Settings form -----------------------*/}
                <div id="forms_grid">
                    <div className="flex items-center justify-between mb-5">
                        <h3 className="font-semibold text-lg dark:text-white-light">Company Details</h3>
                    </div>
                    <div className="mb-5">
                        <form className="space-y-5" onSubmit={handleSubmit}>
                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coName">Company Name</label>
                                    <input id="coName" type="text" className="form-input" placeholder="Enter Company Name" value={company_name} onChange={(e) => setComName(e.target.value)} required />
                                </div>
                                <div>
                                    <label htmlFor="countryId">Country</label>
                                    <div>
                                        <select className="form-select text-dark" value={com_country} onChange={(e) => setComCountry(e.target.value)} required >
                                            <option value="">Select Country</option>
                                            <option value="1">Afganistan</option>
                                            <option value="0">American Samoa</option>
                                            <option value="0">Australia</option>
                                            <option value="0">Bangladesh</option>
                                            <option value="0">Bhutan</option>
                                            <option value="0">China</option>
                                            <option value="0">Denmark</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coShortName">Site Short Name</label>
                                    <input id="coShortName" type="text" placeholder="Enter Site Short Name" className="form-input" value={com_short_name} onChange={(e) => setComStName(e.target.value)} required />
                                </div>
                                <div>
                                    <label htmlFor="coAddress">Address</label>
                                    <input id="coAddress" type="text" placeholder="Enter Address" className="form-input" value={com_address} onChange={(e) => setComAddress(e.target.value)} required />
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4" id="tagging">
                                <div>
                                    <label htmlFor="coEmail">Email</label>
                                    <input id="coEmail" type="email" placeholder="Enter Email" className="form-input" value={com_email} onChange={(e) => setComEmail(e.target.value)} required />
                                </div>
                                <div>
                                    <label htmlFor="coTin">TIN</label>
                                    <input id="coTin" type="tel" placeholder="Enter TIN Number" className="form-input" value={com_tin} onChange={(e) => setComTin(e.target.value)} required />
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coPhone">Phone</label>
                                    <input id="coPhone" type="tel" placeholder="Enter Phone Number" className="form-input" value={com_phone} onChange={(e) => setComPhone(e.target.value)} required />
                                </div>
                                <div>
                                    <div style={{ display: 'flex'}}>
                                        <div style ={{ width: '550px'}}>
                                            <label htmlFor="loginPageLogo">Login Page Logo (Recomended size: 300*120)</label>
                                            <input id="loginPageLogo" type="file" placeholder="Enter User Email" accept=".jpeg, .png, .jpg, .PNG" onChange={(e)=>setLoginLogo(e.target.files![0])} 
                                            className="relative m-0 block w-full min-w-0 flex-auto rounded border border-solid border-neutral-300 bg-clip-padding px-3 py-[0.32rem] text-base font-normal text-neutral-700 transition duration-300 ease-in-out file:-mx-3 file:-my-[0.32rem] file:overflow-hidden file:rounded-none file:border-0 file:border-solid file:border-inherit file:bg-neutral-100 file:px-3 file:py-[0.32rem] file:text-neutral-700 file:transition file:duration-150 file:ease-in-out file:[border-inline-end-width:1px] file:[margin-inline-end:0.75rem] hover:file:bg-neutral-200 " />
                                        </div>
                                        <div style ={{  marginLeft: '20px', marginTop: '10px', width: '200px', height: '60px', overflow: 'hidden', border: '1px solid #e5e7eb', borderRadius: '5px' }}>
                                            <img id="login_file" src={'/assets/images/company/'+ login_logo} alt="img" className="w-44 h-15  object-cover" />
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coBankName">Bank Name</label>
                                    <input id="coBankName" type="text" placeholder="Enter Bank Name" className="form-input" value={com_bank} onChange={(e) => setComBank(e.target.value)}  />
                                </div>
                                <div>
                                    <label htmlFor="coBranch">Branch</label>
                                    <input id="coBranch" type="text" placeholder="Enter Branch" className="form-input" value={com_b_branch} onChange={(e) => setComBnkBranch(e.target.value)}  />
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coAcNo">A/C No</label>
                                    <input id="coAcNo" type="text" placeholder="Enter A/C No" className="form-input" value={com_acc_no} onChange={(e) => setComAccNo(e.target.value)} />
                                </div>
                                <div>
                                  <div style={{ display: 'flex'}}>
                                    <div style ={{ width: '550px'}}>
                                        <label htmlFor="invoiceLogo">Invoice Logo  (Recomended size: 300*120)</label>
                                        <input id="invoiceLogo" type="file" placeholder="Enter User Email" accept=".jpeg, .png, .jpg, .PNG" onChange={(e)=>setInvoiceLogo(e.target.files![0])} 
                                        className="relative m-0 block w-full min-w-0 flex-auto rounded border border-solid border-neutral-300 bg-clip-padding px-3 py-[0.32rem] text-base font-normal text-neutral-700 transition duration-300 ease-in-out file:-mx-3 file:-my-[0.32rem] file:overflow-hidden file:rounded-none file:border-0 file:border-solid file:border-inherit file:bg-neutral-100 file:px-3 file:py-[0.32rem] file:text-neutral-700 file:transition file:duration-150 file:ease-in-out file:[border-inline-end-width:1px] file:[margin-inline-end:0.75rem] hover:file:bg-neutral-200 " />
                                    </div>
                                    <div style ={{ marginLeft: '20px', marginTop: '10px', width: '200px', height: '60px', overflow: 'hidden', border: '1px solid #e5e7eb', borderRadius: '5px'}}>
                                        <img id="invoice_file" src={'/assets/images/company/'+ invoice_logo} alt="img" className="w-44 h-15 object-cover" />
                                    </div>
                                  </div>
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="customerType">Default Currancy</label>
                                    <div>
                                        <select className="form-select text-dark" value={com_currency} onChange={(e) => setComCurrency(e.target.value)} required >
                                            <option value="">Select Currency</option>
                                            <option value="1">Taka</option>
                                            <option value="2">Rupee</option>
                                            <option value="3">Dollar</option>
                                            <option value="4">Euro</option>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <label htmlFor="coBin">BIN</label>
                                    <input id="coBin" type="tel" placeholder="Enter BIN Number" className="form-input" value={com_bin} onChange={(e) => setComBin(e.target.value)}  />
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="coBusinessNature">Business Nature</label>
                                    <input id="coBusinessNature" type="text" placeholder="Enter Business Nature" className="form-input" value={com_buss_nature} onChange={(e) => setComBussNature(e.target.value)}  />
                                </div>
                                <div>
                                    <label htmlFor="coBusinessEconomics">Business Economics</label>
                                    <input id="coBusinessEconomics" type="text" placeholder="Enter Business Economics" className="form-input" value={com_buss_eco} onChange={(e) => setComBussEco(e.target.value)}  />
                                </div>
                            </div>

                            <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
                                <div>
                                    <label htmlFor="customerType">Company Vat Type</label>
                                    <div>
                                        <select className="form-select text-dark" value={com_vat_type} onChange={(e) => setComVatType(e.target.value)} required >
                                            <option value="">Please Select Company Vat Type</option>
                                            <option value="1">Deducted</option>
                                            <option value="0">Not Deducted</option>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <label htmlFor="authorisedPersonId">Authorised Person</label>
                                    <div>
                                        <select className="form-select text-dark" value={com_auth_person} onChange={(e) => setComAuthPerson(e.target.value)} required >
                                            <option value="">Select Authorised Person</option>
                                            {initialRecords.map((option, index) => (
                                                <option key={index} value={option.id}>
                                                    {option.personName}
                                                </option>
                                            ))}
                                            
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div className="flex items-center justify-center gap-6 pt-10">
                                <button type="submit" className="btn btn-success gap-2">
                                    <IconFile className="w-5 h-5 ltr:mr-2 rtl:ml-2" />
                                    Submit
                                </button>
                                <Link to={"/index"} >
                                <button type="button" className="btn btn-danger gap-2" >
                                    <IconTrashLines className="w-5 h-5 ltr:mr-2 rtl:ml-2" />
                                    Cancel
                                </button>
                                </Link>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default index;
