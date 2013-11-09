package com.flagleader.builder.dialogs;

import com.flagleader.builder.ResourceTools;
import com.flagleader.server.RuleThreadInfos;
import com.flagleader.server.RuleThreadServer;
import com.flagleader.util.StringUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class L extends f
{
  private Text f;
  Combo a;
  Combo b;
  Combo c;
  Combo d;
  StyledText e;

  public L()
  {
    super(new Shell());
  }

  public L(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(ResourceTools.getMessage("title.ServerSettingDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 200, 2);
    a(localComposite2, ResourceTools.getMessage("ruleServerPort.ServerSettingDialog"));
    this.f = b(localComposite2, 2048, 200, 16);
    this.f.setText(String.valueOf(RuleThreadServer.d.getPort()));
    a(localComposite2, ResourceTools.getMessage("streamtype.ServerSettingDialog"));
    this.a = c(localComposite2, 2048, 200, 16);
    this.a.setItems(new String[] { ResourceTools.getMessage("notziptype.ServerSettingDialog"), ResourceTools.getMessage("ziptype.ServerSettingDialog") });
    this.a.select(RuleThreadServer.d.getStreamtype());
    a(localComposite2, ResourceTools.getMessage("dbupdatetype.ServerSettingDialog"));
    this.d = c(localComposite2, 2048, 200, 16);
    this.d.setItems(new String[] { ResourceTools.getMessage("notupdate.ServerSettingDialog"), ResourceTools.getMessage("update.ServerSettingDialog") });
    this.d.select(RuleThreadServer.d.isAutoupdate() ? 1 : 0);
    a(localComposite2, ResourceTools.getMessage("ruleServerAccept.ServerSettingDialog"));
    this.e = new StyledText(localComposite2, 8391426);
    this.e.setText(RuleThreadServer.d.getAcceptIPs());
    GridData localGridData = new GridData(200, 64);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.e.setLayoutData(localGridData);
    return localComposite1;
  }

  protected void okPressed()
  {
    try
    {
      String str = this.e.getText();
      str = StringUtil.replace("\n", ";", str);
      str = StringUtil.replace("\r", "", str);
      str = StringUtil.replace(";;", ";", str);
      RuleThreadServer.d.setAcceptIPs(str);
      RuleThreadServer.d.setPort(Integer.parseInt(this.f.getText()));
      RuleThreadServer.d.setStreamtype(this.a.getSelectionIndex());
      RuleThreadServer.d.setAutoupdate(this.d.getSelectionIndex() == 1);
      RuleThreadServer.d.save();
      super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.L
 * JD-Core Version:    0.6.0
 */