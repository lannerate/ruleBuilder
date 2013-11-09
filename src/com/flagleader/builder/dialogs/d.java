package com.flagleader.builder.dialogs;

import com.flagleader.a.a.r;
import com.flagleader.engine.Property;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

class d extends SelectionAdapter
{
  d(AboutLicenseDialog1 paramAboutLicenseDialog1)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String[] arrayOfString = { "*.rlc" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell());
    localFileDialog.setFilterExtensions(arrayOfString);
    String str1 = localFileDialog.open();
    if (str1 != null)
    {
      String str2 = Property.getInstance().getRuleEngineClassDir();
      if (StringUtil.isEmpty(str2))
        if (new File(FileUtil.getCurrentDir(), "rules").exists())
          str2 = new File(FileUtil.getCurrentDir(), "rules").getPath();
        else
          str2 = FileUtil.getCurrentDir();
      try
      {
        FileUtil.copy(new File(str1), new File(str2, "ruleengine.rlc"), true);
        r.a("ruleengine.rlc");
        if (this.a.a != null)
        {
          this.a.a.setText(r.c() + FileUtil.newline + r.a());
          this.a.a.setSize(this.a.a.computeSize(-1, -1));
        }
        else
        {
          this.a.b.setText(r.c() + FileUtil.newline + r.a());
          this.a.b.setSize(this.a.b.computeSize(-1, -1));
        }
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d
 * JD-Core Version:    0.6.0
 */