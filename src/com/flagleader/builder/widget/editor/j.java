package com.flagleader.builder.widget.editor;

import com.flagleader.builder.BuilderConfig;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

public class j
{
  private s a;

  public j(s params)
  {
    this.a = params;
  }

  public void a(FontData[] paramArrayOfFontData)
  {
    this.a.n().getTextWidget().setFont(BuilderConfig.getInstance().getTextFont());
  }

  public void a()
  {
    FileDialog localFileDialog = new FileDialog(Display.getCurrent().getActiveShell(), 4096);
    localFileDialog.setFilterExtensions(this.a.u());
    String str = localFileDialog.open();
    if ((str == null) || (str.length() == 0))
      return;
    try
    {
      this.a.m().a(str);
      this.a.m().b();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void b()
  {
    if (!this.a.m().c())
      return;
    boolean bool = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "确认保存", "您确实要保存文件吗？");
    if (bool)
      try
      {
        this.a.m().a();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
  }

  public boolean a(FindReplaceDocumentAdapter paramFindReplaceDocumentAdapter, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i = 0;
    IRegion localIRegion = null;
    try
    {
      int j = this.a.n().getTextWidget().getCaretOffset();
      if (!paramBoolean1)
      {
        Point localPoint = this.a.n().getSelectedRange();
        if (localPoint.x != localPoint.y)
          j = localPoint.x - 1;
      }
      if (j >= paramFindReplaceDocumentAdapter.length())
        j = paramFindReplaceDocumentAdapter.length() - 1;
      if (j < 0)
        j = 0;
      localIRegion = paramFindReplaceDocumentAdapter.find(j, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      if (localIRegion != null)
      {
        this.a.n().setSelection(new TextSelection(this.a.m(), localIRegion.getOffset(), localIRegion.getLength()), true);
        i = 1;
      }
    }
    catch (BadLocationException localBadLocationException)
    {
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
    }
    return i;
  }

  public void a(FindReplaceDocumentAdapter paramFindReplaceDocumentAdapter, String paramString)
  {
    try
    {
      paramFindReplaceDocumentAdapter.replace(paramString, false);
    }
    catch (BadLocationException localBadLocationException)
    {
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.j
 * JD-Core Version:    0.6.0
 */