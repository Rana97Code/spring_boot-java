

import React, { lazy } from 'react';

// const file = lazy(() => import('../../public/assets/excel_file/'));
const Index = lazy(() => import('../pages/Index'));
const Profile = lazy(() => import('../pages/GeneralSettings/User/Profile'));
const LoginCover = lazy(() => import('../pages/Authentication/LoginCover'));
const Customers = lazy(() => import('../pages/Relationship/Customers/Index'));
const AddCustomers = lazy(() => import('../pages/Relationship/Customers/AddCustomers'));
const EditCustomers = lazy(() => import('../pages/Relationship/Customers/EditCustomers'));
const Suppliers = lazy(() => import('../pages/Relationship/Suppliers/index'));
const AddSuppliers = lazy(() => import('../pages/Relationship/Suppliers/AddSuppliers'));
const EditSuppliers = lazy(() => import('../pages/Relationship/Suppliers/EditSuppliers'));
const Items = lazy(() => import('../pages/Inventory/Items/index'));
const ItemsAdd = lazy(() => import('../pages/Inventory/Items/AddItems'));
const ItemsEdit = lazy(() => import('../pages/Inventory/Items/EditItems'));
const RawMatOpeningStock = lazy(() => import('../pages/Inventory/OpeningStock/RawMaterials'));
const FinishOpeningStock = lazy(() => import('../pages/Inventory/OpeningStock/FinishGoods'));
const CompanySettings = lazy(() => import('../pages/GeneralSettings/CompanySettings/index'));
const AuthorisedPerson = lazy(() => import('../pages/GeneralSettings/AuthorisedPerson/index'));
const AuthorisedPersonAdd = lazy(() => import('../pages/GeneralSettings/AuthorisedPerson/component/authorisedAdd'));
const AuthorisedPersonEdit = lazy(() => import('../pages/GeneralSettings/AuthorisedPerson/component/authorisedEdit'));
const Permission = lazy(() => import('../pages/GeneralSettings/User/permission'));
const PermissionEdit = lazy(() => import('../pages/GeneralSettings/User/components/permissionEdit'));
const Role = lazy(() => import('../pages/GeneralSettings/User/role'));
const UserRoleEdit = lazy(() => import('../pages/GeneralSettings/User/components/roleEdit'));
const User  = lazy(() => import('../pages/GeneralSettings/User/index'));
const UserEdit  = lazy(() => import('../pages/GeneralSettings/User/components/userEdit'));
const UserAdd  = lazy(() => import('../pages/GeneralSettings/User/components/userAdd'));
const UserRolePermission  = lazy(() => import('../pages/GeneralSettings/User/userRolePermission'));
const UserRole  = lazy(() => import('../pages/GeneralSettings/User/role'));
const UserPermission  = lazy(() => import('../pages/GeneralSettings/User/userPermission'));
const UserView  = lazy(() => import('../pages/GeneralSettings/User/components/userView'));
const Unit = lazy(() => import('../pages/GeneralSettings/Unit/index'));
const AddUnit = lazy(() => import('../pages/GeneralSettings/Unit/AddUnit'));
const EditUnit = lazy(() => import('../pages/GeneralSettings/Unit/EditUnit'));
const Costing = lazy(() => import('../pages/GeneralSettings/Costing/index'));
const CostingEdit = lazy(() => import('../pages/GeneralSettings/Costing/components/costingEdit'));
const CustomHouse = lazy(() => import('../pages/GeneralSettings/CustomHouse/index'));
const CustomHouseAdd = lazy(() => import('../pages/GeneralSettings/CustomHouse/components/addCustomHouse'));
const CustomHouseEdit = lazy(() => import('../pages/GeneralSettings/CustomHouse/components/editCustomHouse'));
const HsCode = lazy(() => import('../pages/GeneralSettings/HsCode/index'));
const CpcCode = lazy(() => import('../pages/GeneralSettings/CpcCode/index'));
const CpcAdd = lazy(() => import('../pages/GeneralSettings/CpcCode/components/cpcAdd'));
const CpcEdit = lazy(() => import('../pages/GeneralSettings/CpcCode/components/cpcEdit'));

const LocalPurchase = lazy(() => import('../pages/Production/Procurement/LocalPurchase/index'));
const LocalPurchaseAdd = lazy(() => import('../pages/Production/Procurement/LocalPurchase/components/addLocalPurchase'));

const ForeignPurchase = lazy(() => import('../pages/Production/Procurement/ForeigenPurchase/index'));





const routes = [
    {
        path: '/',
        element: <LoginCover />,
        layout: 'blank',
    },
    {
        path: '/index',
        element: <Index />,
    },
    {
        path: '/pages/relationship/customers',
        element: <Customers />,
    },
    {
        path: '/pages/relationship/customers/add',
        element: <AddCustomers />,
    },
    {
        path: '/pages/relationship/customers/edit/:id',
        element: <EditCustomers />,
    },
    {
        path: '/pages/relationship/suppliers',
        element: <Suppliers />,
    },
    {
        path: '/pages/relationship/suppliers/add',
        element: <AddSuppliers />,
    },
    {
        path: '/pages/relationship/suppliers/edit/:id',
        element: <EditSuppliers />,
    },
    {
        path: '/pages/user/index',
        element: <User />,
    },
    {
        path: '/pages/user/edit',
        element: <UserEdit />,
    },
    {
        path: '/pages/user/add',
        element: <UserAdd />,
    },
    {
        path: '/pages/user/userRolePermission',
        element: <UserRolePermission />,
    },
    {
        path: '/pages/user/userRole',
        element: <UserRole />,
    },
    {
        path: '/pages/user/userPermissions',
        element: <UserPermission />,
    },
    {
        path: '/pages/user/view',
        element: <UserView />,
    },
    {
        path: '/pages/inventory/items',
        element: <Items />,
    },
    {
        path: '/pages/inventory/items/add',
        element: <ItemsAdd />,
    },
    {
        path: '/pages/inventory/items/edit/:id',
        element: <ItemsEdit />,
    },
    {
        path: '/pages/inventory/opening/rawmaterials',
        element: <RawMatOpeningStock />,
    },
    {
        path: '/pages/inventory/opening/finishgoods',
        element: <FinishOpeningStock />,
    },
    {
        path: '/pages/procurment/local_purchase/index',
        element: <LocalPurchase />,
    },
    {
        path: '/pages/procurment/local_purchase/add',
        element: <LocalPurchaseAdd />,
    },
    {
        path: '/pages/procurment/foreign_purchase/index',
        element: <ForeignPurchase />,
    },
    {
        path: '/pages/settings/Company_Settings',
        element: <CompanySettings />,
    },
    {
        path: '/pages/settings/authorised_person/index',
        element: <AuthorisedPerson />,
    },
    {
        path: '/pages/settings/authorised_person/add',
        element: <AuthorisedPersonAdd />,
    },
    {
        path: '/pages/settings/authorised_person/edit/:id',
        element: <AuthorisedPersonEdit />,
    },
    {
        path: '/pages/settings/unit',
        element: <Unit />,
    },
    {
        path: '/pages/settings/unit/add',
        element: <AddUnit />,
    },
    {
        path: '/pages/settings/unit/edit/:id',
        element: <EditUnit />,
    },
    {
        path: '/pages/settings/costing',
        element: <Costing />,
    },
    {
        path: '/pages/settings/costing/edit/:id',
        element: <CostingEdit />,
    },
    {
        path: '/pages/settings/custom_house',
        element: <CustomHouse />,
    },
    {
        path: '/pages/settings/custom_house/add',
        element: <CustomHouseAdd />,
    },
    {
       path: '/pages/settings/custom_house/edit/:id',
        element: <CustomHouseEdit />,
    },

    {
        path: '/pages/hscode/list',
        element: <HsCode />,
    },

    {
        path: '/pages/cpccode/list',
        element: <CpcCode />,
    },
    {
        path: '/pages/cpccode/add',
        element: <CpcAdd />,
    },
    {
        path: '/pages/cpccode/edit/:id',
        element: <CpcEdit />,
    },
    {
        path: '/pages/user/profile',
        element: <Profile />,
    },
    {
        path: '/pages/user/role',
        element: <Role />,
    },
    {
        path: '/pages/user/userRole/edit',
        element: <UserRoleEdit />,
    },
    {
        path: '/pages/user/permissions',
        element: <Permission />,
    },
    {
        path: '/pages/user/permissions/edit',
        element: <PermissionEdit />,
    },
];
export { routes };