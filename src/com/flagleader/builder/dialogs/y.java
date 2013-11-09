package com.flagleader.builder.dialogs;

import com.flagleader.builder.ResourceTools;
import com.flagleader.server.ServerProperty;
import com.flagleader.util.StringUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class y extends f
{
  private Text g;
  Combo a;
  Combo b;
  Combo c;
  Combo d;
  Combo e;
  StyledText f;

  public y()
  {
    super(new Shell());
  }

  public y(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("title.ServerSettingDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 220, 2);
    a(localComposite2, ResourceTools.getMessage("ruleServerPort.ServerSettingDialog"));
    this.g = b(localComposite2, 2048, 200, 16);
    this.g.setText(String.valueOf(ServerProperty.a().d()));
    a(localComposite2, ResourceTools.getMessage("streamtype.ServerSettingDialog"));
    this.a = c(localComposite2, 2048, 200, 16);
    this.a.setItems(new String[] { ResourceTools.getMessage("notziptype.ServerSettingDialog"), ResourceTools.getMessage("ziptype.ServerSettingDialog") });
    this.a.select(ServerProperty.a().e());
    a(localComposite2, ResourceTools.getMessage("receivelogtype.ServerSettingDialog"));
    this.b = c(localComposite2, 2048, 200, 16);
    this.b.setItems(new String[] { ResourceTools.getMessage("notlogtype.ServerSettingDialog"), ResourceTools.getMessage("lottype.ServerSettingDialog") });
    this.b.select(ServerProperty.a().h());
    a(localComposite2, ResourceTools.getMessage("executelogtype.ServerSettingDialog"));
    this.c = c(localComposite2, 2048, 200, 16);
    this.c.setItems(new String[] { ResourceTools.getMessage("notlogtype.ServerSettingDialog"), ResourceTools.getMessage("lottype.ServerSettingDialog") });
    this.c.select(ServerProperty.a().i());
    a(localComposite2, ResourceTools.getMessage("dbupdatetype.ServerSettingDialog"));
    this.d = c(localComposite2, 2048, 200, 16);
    this.d.setItems(new String[] { ResourceTools.getMessage("notupdate.ServerSettingDialog"), ResourceTools.getMessage("update.ServerSettingDialog") });
    this.d.select(ServerProperty.a().j());
    a(localComposite2, ResourceTools.getMessage("tracelogtype.ServerSettingDialog"));
    this.e = c(localComposite2, 2048, 200, 16);
    this.e.setItems(new String[] { ResourceTools.getMessage("notracelog.ServerSettingDialog"), ResourceTools.getMessage("tracelog.ServerSettingDialog") });
    this.e.select(ServerProperty.a().k());
    a(localComposite2, ResourceTools.getMessage("ruleServerAccept.ServerSettingDialog"));
    this.f = new StyledText(localComposite2, 8391426);
    this.f.setText(ServerProperty.a().c());
    GridData localGridData = new GridData(200, 64);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.f.setLayoutData(localGridData);
    return localComposite1;
  }

  protected void okPressed()
  {
    try
    {
      ServerProperty.a().e(this.c.getSelectionIndex());
      ServerProperty.a().d(this.b.getSelectionIndex());
      String str = this.f.getText();
      str = StringUtil.replace("\n", ";", str);
      str = StringUtil.replace("\r", "", str);
      str = StringUtil.replace(";;", ";", str);
      ServerProperty.a().a(str);
      ServerProperty.a().a(Integer.parseInt(this.g.getText()));
      ServerProperty.a().b(this.a.getSelectionIndex());
      ServerProperty.a().f(this.d.getSelectionIndex());
      ServerProperty.a().g(this.e.getSelectionIndex());
      ServerProperty.a().b();
      super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.y
 * JD-Core Version:    0.6.0
 */