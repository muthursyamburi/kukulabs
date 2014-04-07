import wx

class MainWindow(wx.Frame):
	def __init__(self, parent, id, title):
		wx.Frame.__init__(self, parent, wx.ID_ANY, title, size =(450,200), style=wx.DEFAULT_FRAME_STYLE | wx.NO_FULL_REPAINT_ON_RESIZE )
		self.control = wx.TextCtrl(self, style = wx.TE_MULTILINE )
		self.Show(True)

app = wx.App()
window = MainWindow(None, -1, "Small Editor")
# window = wx.Frame(None, -1, "First Window!")
# window.Show()
app.MainLoop()