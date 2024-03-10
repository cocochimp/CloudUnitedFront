import Vue from 'vue'
import 'element-ui/lib/theme-chalk/index.css'

import {
    Button,
    Dialog,
    Drawer,
    Dropdown,
    DropdownMenu,
    DropdownItem,
    Descriptions,
    Pagination,
    Input,
    InputNumber,
    MessageBox,
    Message,
    Checkbox,
    CheckboxGroup,
    CheckboxButton,
    Menu,
    Submenu,
    MenuItem,
    MenuItemGroup,
    Table,
    TableColumn,
    DatePicker,
    Form,
    FormItem,
    Slider,
    Upload,
    Icon,
    Select,
    Option,
    Container,
    Header,
    Aside,
    Main,
    Tag,
    Tree,
    Breadcrumb,
    BreadcrumbItem,
    Carousel,
    Divider

} from 'element-ui'

Vue.use(Button)
Vue.use(Dialog)
Vue.use(Drawer)
Vue.use(Dropdown)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.use(Descriptions)
Vue.use(Input)
Vue.use(InputNumber)
Vue.use(Checkbox)
Vue.use(CheckboxGroup)
Vue.use(CheckboxButton)
Vue.use(Pagination)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(DatePicker)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Slider)
Vue.use(Upload)
Vue.use(Icon)
Vue.use(Select)
Vue.use(Option)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Tag)
Vue.use(Tree)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Carousel)
Vue.use(Divider)


Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;
Vue.prototype.$message = Message;


//elementUI设置语言
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'
locale.use(lang)