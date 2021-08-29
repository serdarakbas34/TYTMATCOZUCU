import configparser
import wx
import wx.lib.agw.flatnotebook as fnb

class IDE(wx.Frame):
    def __init__(self, *args, **kwargs):
        wx.Frame.__init__(self, *args, **kwargs)
        self.SetIcon(wx.Icon("../assets/IDE.png", wx.BITMAP_TYPE_PNG))
        self.InitUI()
        self.Show()

    def InitUI(self):
        panel = wx.Panel(self)
        vertsizer = wx.BoxSizer(wx.HORIZONTAL)

        self.CreateStatusBar()
        menubar = wx.MenuBar()
        filemenu = wx.Menu()
        menunew = filemenu.Append(wx.ID_NEW, "&New", "Yeni bir dosya oluştur.")
        menuopen = filemenu.Append(wx.ID_OPEN, "&Open", "Düzenlemek için bir dosya açın.")
        menusave = filemenu.Append(wx.ID_SAVE, "&Save", "Geçerli dosyayı kaydet")
        menusaveas = filemenu.Append(wx.ID_ANY, "SaveAs", "Geçerli dosyayı belirli bir dosya adıyla kaydedin")
        menuabout = filemenu.Append(wx.ID_ABOUT, "&About", "IDE hakkında bilgi")
        menuexit = filemenu.Append(wx.ID_EXIT, "E&xit", "IDE'yi kapat")
        self.Bind(wx.EVT_MENU, self.OnNew, menunew)
        self.Bind(wx.EVT_MENU, self.OnOpen, menuopen)
        self.Bind(wx.EVT_MENU, self.OnSave, menusave)
        self.Bind(wx.EVT_MENU, self.OnSaveAs, menusaveas)
        self.Bind(wx.EVT_MENU, self.OnAbout, menuabout)
        self.Bind(wx.EVT_MENU, self.OnExit, menuexit)
        menubar.Append(filemenu, "&File")
        runmenu = wx.Menu()
        menuinterpret = runmenu.Append(wx.ID_ANY, "&Interpret", "Programı çalıştırmak için python yorumlayıcısını kullanın.")
        menudebug = runmenu.Append(wx.ID_ANY, "&Debug", "Programı hata ayıklama çıktısıyla çalıştırın")
        self.Bind(wx.EVT_MENU, self.OnInterpret, menuinterpret)
        self.Bind(wx.EVT_MENU, self.OnDebug, menudebug)
        menubar.Append(runmenu, "&Run")
        settingsmenu = wx.Menu()
        menupython = settingsmenu.Append(wx.ID_ANY, "&Python", "Python ayarlarını yapılandırın.")
        self.Bind(wx.EVT_MENU, self.OnPython, menupython)
        menubar.Append(settingsmenu, "&Settings")
        self.SetMenuBar(menubar)

        toolbar = self.CreateToolBar()
        interprettool = toolbar.AddLabelTool(wx.ID_ANY, "Interpret", wx.Bitmap("../assets/run.png"))
        debugtool = toolbar.AddLabelTool(wx.ID_ANY, "Debug", wx.Bitmap("../assets/debug.png"))
        savetool = toolbar.AddLabelTool(wx.ID_ANY, "Save", wx.Bitmap("../assets/save.png"))
        newtool = toolbar.AddLabelTool(wx.ID_ANY, "New File", wx.Bitmap("../assets/newfile.png"))
        opentool = toolbar.AddLabelTool(wx.ID_ANY, "Open File", wx.Bitmap("../assets/open.png"))
        toolbar.Realize()
        self.Bind(wx.EVT_TOOL, self.OnInterpret, interprettool)
        self.Bind(wx.EVT_TOOL, self.OnDebug, debugtool)
        self.Bind(wx.EVT_TOOL, self.OnSave, savetool)
        self.Bind(wx.EVT_TOOL, self.OnNew, newtool)
        self.Bind(wx.EVT_TOOL, self.OnOpen, opentool)

        self.notebook = filenotebook(panel, agwStyle=fnb.FNB_NO_X_BUTTON | fnb.FNB_NO_NAV_BUTTONS | fnb.FNB_X_ON_TAB)
        self.notebook.add_file("untitled", "")
        vertsizer.Add(self.notebook, proportion=1, flag=wx.EXPAND)


        panel.SetSizer(vertsizer)
        panel.SetAutoLayout(1)
        vertsizer.Fit(panel)

    def OnNew(self, event):
        self.notebook.add_file("untitled", "")

    def OnOpen(self, event):
        dialog = wx.FileDialog(self, "Düzenlemek istediğiniz dosyayı seçiniz.", "", "", "*.*", wx.OPEN)
        if dialog.ShowModal() == wx.ID_OK:
            self.notebook.add_file(dialog.GetFilename(), dialog.GetDirectory())
        dialog.Destroy()

    def OnSave(self, event):
        self.notebook.save()

    def OnSaveAs(self, event):
        selection = self.notebook.get_selection()
        dialog = wx.FileDialog(self, "Dosyayı ne olarak kaydetmek istediğinizi seçiniz.", selection.directory, selection.name,
                               "*.*", wx.SAVE)
        if dialog.ShowModal() == wx.ID_OK:
            self.notebook.save_as(dialog.GetFilename(), dialog.GetDirectory())
        dialog.Destroy()

    def OnAbout(self, event):
        description = """Bu IDE  programlama dilleri dersi projesi olarak Hi I am siri ekibi tarafından oluşturulmuştur."""

        info = wx.AboutDialogInfo()
        info.SetIcon(wx.Icon("../assets/python.png", wx.BITMAP_TYPE_PNG))
        info.SetName("IDE")
        info.SetVersion("Alpha")
        info.SetDescription(description)
        info.SetCopyright(" © 2021 Hi I am siri")
        wx.AboutBox(info)

    def OnExit(self, event):
        self.Close()

    def OnInterpret(self, event):
        self.notebook.interpret()

    def OnDebug(self, event):
        self.notebook.debug()

    def OnPython(self, event):
        dialog = wx.TextEntryDialog(self, "Python yolunuz nerede?", caption="Python Path")
        if dialog.ShowModal() == wx.ID_OK:
            pythonpath = dialog.GetValue()
            file = open("../config/settings.ini", "w")
            config = configparser.ConfigParser()
            config.add_section("python")
            config.set("python", "path", pythonpath)
            config.write(file)
            file.close()
        dialog.Destroy()


class DebugDialog(wx.Frame):
    def __init__(self, *args, **kwargs):
        wx.Frame.__init__(self, *args, **kwargs)
        self.InitUI()


app = wx.App(redirect=True)
window = IDE(parent=None, title="IDE", size=(1920, 1080))
app.MainLoop(window)
